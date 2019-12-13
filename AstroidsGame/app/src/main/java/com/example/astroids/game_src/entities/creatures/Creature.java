package com.example.astroids.game_src.entities.creatures;

import android.graphics.Canvas;

import com.example.astroids.game_src.entities.Entity;

public abstract class Creature extends Entity {

    protected double speed;
    protected double angle;

    protected float speedx, speedy;



    protected boolean visible;

    public Creature(float x, float y, int width, int height)
    {
        super(x, y, width, height);
        visible = true;
    }

    public void move(){

//        x += (float) (speed * Math.cos(angle));
//        y += (float) (speed * Math.sin(angle));

        x += speedx;
        y += speedy;
    }

}
