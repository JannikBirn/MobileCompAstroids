package com.example.astroids.game_src.entities.creatures.player;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.example.astroids.R;
import com.example.astroids.game_src.entities.creatures.Creature;
import com.example.astroids.game_src.main.Handler;

public class Player extends Creature {

    //Debugging
    private static final String TAG = "PLAYER";

    private BulletManager bulletManager;


    public Player(float x, float y) {
        super(x, y, 0, 0);
        Bitmap bitmap = BitmapFactory.decodeResource(Handler.getInstance().getMainActivity().getResources(), R.drawable.raumschiff);
        height = bitmap.getHeight();
        width = bitmap.getWidth();

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
        speedy = 5 * (Handler.getInstance().getAccelrator().values[0]-5);

        move();

        bulletManager.fire();
        bulletManager.tick();

    }

    @Override
    public void render(Canvas c) {
//        c.drawRect(x, y, x + width, y + height, paint);
        Bitmap bitmap = BitmapFactory.decodeResource(Handler.getInstance().getMainActivity().getResources(), R.drawable.raumschiff);
        c.drawBitmap(bitmap,x,y,null);

        bulletManager.render(c);
    }


}
