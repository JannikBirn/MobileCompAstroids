package com.example.astroids.game_src.entities.creatures.player;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.astroids.game_src.entities.Entity;
import com.example.astroids.game_src.entities.creatures.Creature;
import com.example.astroids.game_src.main.Handler;

public class Player extends Creature {

    //Debugging
    private static final String TAG = "PLAYER";

    private BulletManager bulletManager;

    public Player(float x, float y, int width, int height) {
        super(x, y, width, height);
        Handler.getInstance().setPlayer(this);
        bulletManager = new BulletManager(this);

        canMoveOffScreen = false;

    }

    @Override
    public void tick() {
        //Log.d(TAG,"Player movement checking: "+Math.abs(Handler.getInstance().getAccelrator().values[1]) );
//        if (Math.abs(Handler.getInstance().getAccelrator().values[1]) > 1){
//            Log.d(TAG,"Player movement Triggerd");
//        }
        speedx = 5 * Handler.getInstance().getAccelrator().values[1];
        speedy = 5 * Handler.getInstance().getAccelrator().values[0];

        move();

        bulletManager.fire();
        bulletManager.tick();

    }

    @Override
    public void render(Canvas c) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        c.drawRect(x, y, x + width, y + height, paint);

        bulletManager.render(c);
    }


}
