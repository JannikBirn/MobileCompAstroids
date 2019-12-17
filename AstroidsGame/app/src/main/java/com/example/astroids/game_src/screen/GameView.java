package com.example.astroids.game_src.screen;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.astroids.game_src.main.Game;
import com.example.astroids.game_src.main.Handler;


public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    public boolean NEWGAMEONSTART = true;

    private Game game;

    public GameView(Context context) {
        super(context);
        getHolder().addCallback(this);

        init();
        setFocusable(true);
    }

    void init(){
        game = new Game(getHolder(), this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Handler.getInstance().setScreenHeight(holder.getSurfaceFrame().height());
        Handler.getInstance().setScreenWith(holder.getSurfaceFrame().width());
        game.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        game.stop();
    }


    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
    }

    public void onPause(Context context){
        game.onPause(context);
        game.stop();
    }

    public void onResume(Context context){
        init();
        game.onResume(context);
    }
}
