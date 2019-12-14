package com.example.astroids.game_src.main;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.SurfaceHolder;

import com.example.astroids.game_src.main.inptu.Accelrator;
import com.example.astroids.game_src.screen.GameView;
import com.example.astroids.game_src.state.GameState;
import com.example.astroids.game_src.state.PauseState;
import com.example.astroids.game_src.state.State;
import com.example.astroids.game_src.state.StateManager;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Game implements Runnable   {


    private int width, height;
    public String title;

    //DEBUGGING
    private static final String TAG = "Game";
    private static final String FILENAME = "GameSave";

    //Game Engine Stuff
    private static final int REFRESHRATE = 60; // fps
    private static final int GAMETICKRATE = 30;
    private static final double TIMEPERGAMETICK = 1000000000 / GAMETICKRATE;
    private static final double TIMEPERFRAMETICK = 1000000000 / REFRESHRATE;

    //Thread stuff
    private Thread thread;
    private boolean running = false;

    //View Stuff
    private SurfaceHolder surfaceHolder;
    private GameView gameView;
    private static Canvas canvas;

    // States
    private State gameState;
    //private State menuState;
    //private State buymenuState;
    //private State afterGameState;

    //Input
    private Accelrator accelrator;


    public Game(SurfaceHolder surfaceHolder, GameView gameView){
        super();
        this.surfaceHolder = surfaceHolder;
        this.gameView = gameView;
        Log.d(TAG,"Game()");
    }

    private void init(){
        Log.d(TAG,"init()");

        if (gameState == null) {
            gameState = new GameState();
        }

        accelrator = new Accelrator();

        if (StateManager.getState() == null) {
            StateManager.setState(gameState);
        }
    }

    @Override
    public void run() {
        Log.d(TAG,"run()");
        init();



        double deltaGameTick = 0;
        double deltaFrameTick = 0;
        long now;
        long lastTime = System.nanoTime();

        //Debbuging
        long timer = 0; // counts to 1 second
        int gameTicks = 0; // counts the game ticks
        int frameTicks = 0;

        while (running) {
            now = System.nanoTime();
            deltaGameTick += (now - lastTime) / TIMEPERGAMETICK;
            deltaFrameTick += (now - lastTime) / TIMEPERFRAMETICK;

            timer += now - lastTime;
            lastTime = now;

            if (deltaGameTick >= 1)
            {
                tick();

                gameTicks++;
                deltaGameTick--;
            }
            if (deltaFrameTick >= 1)
            {
                render();

                frameTicks++;
                deltaFrameTick--;
            }

            if (timer >= 1000000000)
            {
                Log.d(TAG,"Game Ticks:" + gameTicks + "    Frames:" + frameTicks);

                gameTicks = 0;
                frameTicks = 0;
                timer = 0;
            }

        }


        //Stops Thread
    }

    private void tick(){

        if (StateManager.getState() != null){
            StateManager.getState().tick();
        }
    }

    private void render(){

        canvas = null;

        try {
            canvas = this.surfaceHolder.lockCanvas();
            synchronized (surfaceHolder) {
                canvas.drawColor(Color.BLACK);
                if (StateManager.getState() != null){
                    StateManager.getState().render(canvas);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (canvas != null) {
                try {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }




    //Persistent Methods
    public void onPause(Context context){

        if (accelrator != null) {
            accelrator.onPause();
        }
        if (StateManager.getState() != null) {
            try {
                Log.d(TAG, "Saving States");
                FileOutputStream fos = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
                ObjectOutputStream os = new ObjectOutputStream(fos);
                os.writeObject(gameState);

                os.close();
                fos.close();

                Log.d(TAG, "State succesfull saved");
            } catch (Exception e) {
                e.printStackTrace();
                Log.d(TAG, "State not saved");
            }
        }
//        if (StateManager.getState() != null){
//            StateManager.getState().onPause();
//        }
    }

    public void onResume(Context context){
        if (accelrator != null) {
            accelrator.onResume();
        }

        try {
            Log.d(TAG,"Loding State");
            FileInputStream fis = context.openFileInput(FILENAME);
            ObjectInputStream is = new ObjectInputStream(fis);
            State state = (State) is.readObject();

            Log.d(TAG, "State Size:"+ fis.getChannel().size() + "bytes");

            is.close();
            fis.close();

            if (state.getClass() == GameState.class){
                Log.d(TAG,"State is gameState");
                gameState = state;
            }

            Log.d(TAG,"State succesfull loded");
        }catch (Exception e){
            e.printStackTrace();
            Log.d(TAG,"State not loded");
        }

    }





    //Starten des Threads
    public synchronized void start()
    {
        Log.d(TAG,"start()");
        if (running)
            return;

        running = true;
        // wich class we want to start
        thread = new Thread(this);
        // start the thread - Calls run method
        thread.start();
    }

    //Stoppen des Threads
    public synchronized void stop()
    {
        Log.d(TAG,"stop()");
        if (!running)
            return;

        running = false;
        try
        {
            Log.d(TAG,"stopping Thread");
            thread.join();
            Log.d(TAG,"stopped Thread");
        } catch (InterruptedException e)
        {
            e.printStackTrace();
            Log.d(TAG,"stopping Thread FAILED");
        }
    }



}
