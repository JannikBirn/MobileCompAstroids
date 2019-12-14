package com.example.astroids.game_src.entities.creatures;

import android.graphics.Canvas;

import com.example.astroids.game_src.entities.Entity;
import com.example.astroids.game_src.main.Handler;

public abstract class Creature extends Entity {

    protected float speedx, speedy;
    protected boolean canMoveOffScreen;

    public Creature(float x, float y, int width, int height) {
        super(x, y, width, height);
        canMoveOffScreen = true;
    }

    protected void move() {

        x += speedx;
        y += speedy;

        if (!canMoveOffScreen) {
            if (x + width > Handler.getInstance().getScreenWith()) {
                x = Handler.getInstance().getScreenWith() - width;
            } else if (x < 0) {
                x = 0;
            }


            if (y + height > Handler.getInstance().getScreenHeight()) {
                y = Handler.getInstance().getScreenHeight() - height;
            } else if (y < 0) {
                y = 0;
            }
        }
    }

    public boolean destroyOffScreen(){

        if (canMoveOffScreen) {
            if (x + width > Handler.getInstance().getScreenWith()) {
                return true;
            } else if (x < 0) {
                return true;
            }


            if (y + height > Handler.getInstance().getScreenHeight()) {
                return true;
            } else if (y < 0) {
                return true;
            }
        }

        return false;
    }


}
