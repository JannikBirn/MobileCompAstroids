package com.example.astroids.game_src.entities;

import android.graphics.Canvas;

import com.example.astroids.game_src.entities.creatures.Player;

import java.util.ArrayList;

public class EntityManager {

    private Player player;

    private ArrayList<Entity> entities;

    public EntityManager(Player player)
    {
        this.player = player;
        this.entities = new ArrayList<Entity>();
    }

    public void tick()
    {

//        int xStart = (int) Math.max(0, Handler.getInstance().getGameCamera().getxOffset() - 100);
//        int xEnd = (int) Math.min(Handler.getInstance().getWorld().getWidth() * Tile.TILEWIDTH,
//                (Handler.getInstance().getGameCamera().getxOffset() + Handler.getInstance().getWidth()));
//        int yStart = (int) Math.max(0, Handler.getInstance().getGameCamera().getyOffset() - 100);
//        int yEnd = (int) Math.min(Handler.getInstance().getWorld().getHeight() * Tile.TILEHEIGHT,
//                (Handler.getInstance().getGameCamera().getyOffset() + Handler.getInstance().getHeight()));
//
//        for (int i = 0; i < entities.size(); i++)
//        {
//            Entity e = entities.get(i);
//
//            if (e.getX() >= xStart && e.getX() <= xEnd && e.getY() >= yStart && e.getY() <= yEnd)
//            {
//                e.tick();
//                if (e.isDelete())
//                {
//                    entities.remove(i);
//                }
//            }
//        }

        player.tick();
    }

    public void render(Canvas c)
    {
//        int xStart = (int) Math.max(0, Handler.getInstance().getGameCamera().getxOffset() - 100);
//        int xEnd = (int) Math.min(Handler.getInstance().getWorld().getWidth() * Tile.TILEWIDTH,
//                (Handler.getInstance().getGameCamera().getxOffset() + Handler.getInstance().getWidth()));
//        int yStart = (int) Math.max(0, Handler.getInstance().getGameCamera().getyOffset() - 100);
//        int yEnd = (int) Math.min(Handler.getInstance().getWorld().getHeight() * Tile.TILEHEIGHT,
//                (Handler.getInstance().getGameCamera().getyOffset() + Handler.getInstance().getHeight()));
//
//        for (Entity e : entities)
//        {
//            if (e.getX() >= xStart && e.getX() <= xEnd && e.getY() >= yStart && e.getY() <= yEnd)
//            {
//                e.render(g);
//            }
//        }
        player.render(c);
    }


}
