package com.example.astroids.game_src.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.example.astroids.R;
import com.example.astroids.game_src.screen.GameView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Handler.getInstance().setMainActivity(this);

        setContentView(new GameView(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume()");
        if (Handler.getInstance().getAccelrator() != null) {
            Handler.getInstance().getAccelrator().onResume("");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause()");
        if (Handler.getInstance().getAccelrator() != null) {
            Handler.getInstance().getAccelrator().onPause();
        }
    }
}
