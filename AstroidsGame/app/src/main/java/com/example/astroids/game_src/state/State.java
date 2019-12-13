package com.example.astroids.game_src.state;

import android.graphics.Canvas;

public abstract class State {

    public State()
    {

    }

    public abstract void tick();

    public abstract void render(Canvas c);

    public abstract void click();

    public abstract void init();
}
