package com.example.astroids.game_src.main;

import com.example.astroids.game_src.entities.creatures.Player;
import com.example.astroids.game_src.main.inptu.Accelrator;

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
