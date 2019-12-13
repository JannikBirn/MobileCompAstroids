package com.example.astroids.game_src.entities;


import android.graphics.Canvas;

import androidx.constraintlayout.solver.widgets.Rectangle;

public abstract class Entity {

    protected float x,y;
    protected int width,height;
    protected Rectangle bounds;
    protected boolean delete;

    public Entity(float x, float y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        delete = false;

        bounds = new Rectangle();
        bounds.setBounds(0, 0, width,height);
    }

    public abstract void tick();

    public abstract void render(Canvas c);

    public abstract void onResume(String s);

    public float getX()
    {
        return x;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public float getY()
    {
        return y;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public boolean isDelete()
    {
        return delete;
    }

}
