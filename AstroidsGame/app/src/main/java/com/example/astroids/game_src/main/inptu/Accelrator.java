package com.example.astroids.game_src.main.inptu;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

import com.example.astroids.game_src.main.Handler;

public class Accelrator implements SensorEventListener {

    private static final String TAG = "Accelrator";

    private SensorManager sensorManager;
    private Sensor accelrometer;

    public float[] values;

    public Accelrator(){
        Handler.getInstance().setAccelrator(this);
        values = new float[3];

        init();
    }


    public void onResume(String s) {
        sensorManager.registerListener(this,accelrometer,SensorManager.SENSOR_DELAY_GAME);
        Log.d(TAG,"Starten Sensor Listener");
    }

    public void onPause(){
        sensorManager.unregisterListener(this);

        Log.d(TAG,"Stopped Sensor Listener");
    }

    private void init(){
        Log.d(TAG,"Starten Sensor Listener");
        sensorManager = (SensorManager) Handler.getInstance().getMainActivity().getSystemService(Context.SENSOR_SERVICE);
        accelrometer = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);

        sensorManager.registerListener(this,accelrometer,SensorManager.SENSOR_DELAY_GAME);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        //Log.d(TAG,"Sensor: x:"+event.values[0] +"   Sensor: y:"+event.values[1] +"  Sensor: z:"+event.values[2]);
        this.values = event.values;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
