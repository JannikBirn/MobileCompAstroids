package com.example.astroids.game_src.screen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.astroids.game_src.main.Game;
import com.example.astroids.game_src.state.StateManager;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private Game game;

    public GameView(Context context) {
        super(context);
        getHolder().addCallback(this);

        game = new Game(getHolder(), this);
        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        game.start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        game.stop();
    }

    public void update(){

    }

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);

    }
}
