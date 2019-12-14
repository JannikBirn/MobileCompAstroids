package com.example.astroids.game_src.entities.creatures.player;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.astroids.game_src.entities.creatures.Creature;

public class Bullet extends Creature {


    public Bullet(float x, float y, int width, int height) {
        super(x, y, width, height);
        speedy = -40;
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
//        c.save();
//        c.rotate(15,x,y);
        c.drawRect(x, y, x + width, y + height, paint);
//        c.restore();
    }
}
