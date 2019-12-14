package com.example.astroids.game_src.main.inptu;


import android.view.MotionEvent;
import android.view.View;

import com.example.astroids.game_src.main.Handler;

public class Touch implements View.OnTouchListener {

//    private static final String TAG = "Touch";
//
//
//
//    public Touch(){
//        Handler.getInstance().setTouch(this);
//
//    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        v.performClick();

        event.getX();
        event.getY();

        return false;
    }
}
