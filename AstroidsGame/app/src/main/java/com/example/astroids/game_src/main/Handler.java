package com.example.astroids.game_src.main;

import com.example.astroids.game_src.entities.creatures.player.Player;
import com.example.astroids.game_src.main.inptu.Accelrator;
import com.example.astroids.game_src.main.inptu.Touch;

public class Handler {
    //Handler Stuff
    private static final Handler ourInstance = new Handler();

    public static Handler getInstance() {
        return ourInstance;
    }

    private Handler() {
    }

    //Class

    private MainActivity mainActivity;
    private Player player;
    private Accelrator accelrator;
    private Touch touch;
    private int screenHeight, screenWith;

    public Touch getTouch() {
        return touch;
    }

    public void setTouch(Touch touch) {
        this.touch = touch;
    }


    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public int getScreenWith() {
        return screenWith;
    }

    public void setScreenWith(int screenWith) {
        this.screenWith = screenWith;
    }


    public MainActivity getMainActivity() {
        return mainActivity;
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }


    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Accelrator getAccelrator() {
        return accelrator;
    }

    public void setAccelrator(Accelrator accelrator) {
        this.accelrator = accelrator;
    }
}
