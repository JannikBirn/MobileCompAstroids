package com.example.astroids.game_src.state;

import android.graphics.Canvas;

import java.io.Serializable;

public abstract class State implements Serializable {

    public State()
    {

    }

    public abstract void tick();

    public abstract void render(Canvas c);

    public abstract void init();

}
