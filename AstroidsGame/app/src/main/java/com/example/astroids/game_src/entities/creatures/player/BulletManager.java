package com.example.astroids.game_src.entities.creatures.player;

import android.graphics.Canvas;
import android.util.Log;

import com.example.astroids.game_src.entities.Entity;

import java.io.Serializable;
import java.util.ArrayList;

public class BulletManager implements Serializable {

    //Debugging
    private static final String TAG = "BulletManager";

    private  Player player;
    private ArrayList<Bullet> bullets;
    private int attackSpeed;
    private int tickSincelastAttck;

    public BulletManager(Player player) {
        this.player = player;
        this.bullets = new ArrayList<>();
        attackSpeed = 15;
        tickSincelastAttck = 0;
    }

    public void fire(){
        if (tickSincelastAttck >= attackSpeed) {
            bullets.add(new Bullet(player.getX(), player.getY(), 5, 30, 25 , -20));
            bullets.add(new Bullet(player.getX()+(player.getWidth()/2), player.getY(), 5, 30, 25, 0));
            bullets.add(new Bullet(player.getX()+player.getWidth(), player.getY(), 5, 30, 25, 20));

            tickSincelastAttck = 0;
        }else {
            tickSincelastAttck++;
        }
    }

    public void tick(){
        for (int i = 0 ; i < bullets.size(); i++){
            bullets.get(i).tick();
            if (bullets.get(i).destroyOffScreen()){
                bullets.remove(i);
                //Log.d(TAG,"bullet removed Array Size"+bullets.size());
            }
        }
        //Log.d(TAG,"tick()");
    }

    public void render(Canvas c){
        for (Bullet bullet : bullets){
            bullet.render(c);
        }
    }



}
