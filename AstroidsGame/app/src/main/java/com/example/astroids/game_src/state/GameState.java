package com.example.astroids.game_src.state;

import android.graphics.Canvas;

import com.example.astroids.game_src.entities.EntityManager;
import com.example.astroids.game_src.entities.creatures.player.Player;

public class GameState extends State {

    private Player player;
    private EntityManager entityManager;

    public GameState(){
        player = new Player(100,100,100,200);
        entityManager = new EntityManager(player);
    }

    @Override
    public void tick() {
        entityManager.tick();
    }

    @Override
    public void render(Canvas c) {
        entityManager.render(c);
    }



    @Override
    public void init() {

    }

}
