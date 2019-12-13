package com.example.astroids.game_src.state;

public class StateManager {

    //Game State Manager
    private static State currentState = null;

    public static void setState(State state)
    {
        currentState = state;
    }

    public static State getState()
    {
        return currentState;
    }
}
