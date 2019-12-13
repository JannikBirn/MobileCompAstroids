package com.example.astroids.game_src.main;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.SurfaceHolder;

import com.example.astroids.game_src.main.inptu.Accelrator;
import com.example.astroids.game_src.screen.GameView;
import com.example.astroids.game_src.state.GameState;
import com.example.astroids.game_src.state.State;
import com.example.astroids.game_src.state.StateManager;

public class Game implements Runnable   {


    private int width, height;
    public String title;

    //DEBUGGING
    private static final String TAG = "Game";

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
    }

    private void init(){
        gameState = new GameState();
        accelrator = new Accelrator();

        StateManager.setState(gameState);
    }

    @Override
    public void run() {
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
        stop();
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



    public synchronized void start()
    {
        if (running)
            return;

        running = true;
        // wich class we want to start
        thread = new Thread(this);
        // start the thread - Calls run method
        thread.start();
    }

    public synchronized void stop()
    {
        if (!running)
            return;

        running = false;
        try
        {
            thread.join();
        } catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



}
