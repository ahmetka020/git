package com.whoami.mobilprogramlama;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;


public class SensorActivity extends Activity {

    Activity activity = this;

    private ImageView iv_background;
    private TextView textLIGHT_available;
    private TextView textLIGHT_reading;
    private TextView tv_test;

    private SensorManager mySensorManager;
    private Sensor lightSensor;
    private Sensor accelerometer;

    private float[] mGravity;
    private float mAccel;
    private float mAccelCurrent;
    private float mAccelLast;

    boolean motionDetected = true;
    int count = 0;
    Handler handler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        handler = new Handler();

        textLIGHT_available = findViewById(R.id.LIGHT_available);
        textLIGHT_reading = findViewById(R.id.LIGHT_reading);
        tv_test = findViewById(R.id.tv_test);

        iv_background  = findViewById(R.id.iv_background);

        mySensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        lightSensor = mySensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if(lightSensor != null){
            textLIGHT_available.setText("Sensor.TYPE_LIGHT Available");
            mySensorManager.registerListener(
                    lightSensorListener,
                    lightSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);

        } else {
            textLIGHT_available.setText("Sensor.TYPE_LIGHT NOT Available");
        }


        accelerometer = mySensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mAccel = 0.00f;
        mAccelCurrent = SensorManager.GRAVITY_EARTH;
        mAccelLast = SensorManager.GRAVITY_EARTH;

        if(accelerometer != null){
            mySensorManager.registerListener(
                    accelerometerSensorListener,
                    accelerometer,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }



    }

    private final SensorEventListener lightSensorListener = new SensorEventListener(){

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            if(event.sensor.getType() == Sensor.TYPE_LIGHT){
                textLIGHT_reading.setText("LIGHT: " + event.values[0]);
                if (event.values[0] < 200){
                    iv_background.setBackgroundResource(android.R.color.black);
                    textLIGHT_available.setTextColor(getResources().getColor(android.R.color.white));
                    textLIGHT_reading.setTextColor(getResources().getColor(android.R.color.white));
                    tv_test.setTextColor(getResources().getColor(android.R.color.white));
                }

                else {
                    iv_background.setBackgroundResource(android.R.color.white);
                    textLIGHT_available.setTextColor(getResources().getColor(android.R.color.black));
                    textLIGHT_reading.setTextColor(getResources().getColor(android.R.color.black));
                    tv_test.setTextColor(getResources().getColor(android.R.color.black));
                }
            }

        }

    };


    private final SensorEventListener accelerometerSensorListener = new SensorEventListener(){

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
                mGravity = event.values.clone();
                // Shake detection
                float x = mGravity[0];
                float y = mGravity[1];
                float z = mGravity[2];
                mAccelLast = mAccelCurrent;
                mAccelCurrent = (float) Math.sqrt(x*x + y*y + z*z);
                float delta = mAccelCurrent - mAccelLast;
                mAccel = mAccel * 0.9f + delta;
                // Make this higher or lower according to how much
                // motion you want to detect
                if(mAccel > 1){
                   tv_test.setText("ACCELERATION " +mAccel);
                   if (handler != null)
                        handler.removeCallbacksAndMessages(null);
                }

                else {
                    count = 0;
                    handler.post( new Runnable(){
                        public void run() {
                            if (count != 0){
//                                Intent intent = new Intent(activity, MenuActivity.class);
//                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                                intent.putExtra("EXIT", true);
//                                startActivity(intent);
                            }
                            count++;
                            handler.postDelayed(this, 5000);
                        }
                    });
                }
            }

        }
    };



}