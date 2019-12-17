package com.example.astroids.game_src.entities.creatures.player;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.astroids.game_src.entities.creatures.Creature;

public class Bullet extends Creature {

    double angle;
    float speed;


    public Bullet(float x, float y, int width, int height, float speed, double angle) {
        super(x, y, width, height);
        this.angle = 180+angle;
        this.speed = speed;
    }

    @Override
    public void move(){
        speedx = (float) (speed * Math.cos(Math.toRadians(90+angle)));
        speedy = (float) (speed * Math.sin(Math.toRadians(90+angle)));

        super.move();
    }

    @Override
    public void tick() {
        move();
    }

    @Override
    public void render(Canvas c) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        c.save();
        c.rotate((float) angle,x,y);
        c.drawRect(x, y, x + width, y + height, paint);
        c.restore();
    }
}
