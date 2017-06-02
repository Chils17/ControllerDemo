package com.webmyne.controllerdemo.ui;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

import com.webmyne.controllerdemo.R;
import com.webmyne.controllerdemo.adapter.CustomChronometer;

public class ChronometerActivity extends AppCompatActivity {

    private Chronometer simpleChronometer;
    private Button start;
    private Button stop;
    private Button restart;
    private Button setFormat;
    private Button clearFormat;
    private CustomChronometer mChronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chronometer);

        init();

        clickListener();
    }

    private void init() {
        simpleChronometer = (Chronometer) findViewById(R.id.simpleChronometer);
        mChronometer = (CustomChronometer) findViewById(R.id.chronometer);
        start = (Button) findViewById(R.id.startButton);
        stop = (Button) findViewById(R.id.stopButton);
        restart = (Button) findViewById(R.id.restartButton);
        setFormat = (Button) findViewById(R.id.setFormat);
        clearFormat = (Button) findViewById(R.id.clearFormat);

        mChronometer.start();
    }

    private void clickListener() {
        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                simpleChronometer.start();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                simpleChronometer.stop();
            }
        });

        restart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                simpleChronometer.setBase(SystemClock.elapsedRealtime());
            }
        });

        setFormat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                simpleChronometer.setFormat("Time (%s)");
            }
        });

        clearFormat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                simpleChronometer.setFormat(null);
            }
        });

        mChronometer.setOnChronometerTickListener(new CustomChronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(CustomChronometer customChronometer) {
                if (customChronometer.getText().toString().equalsIgnoreCase("00:05:0")) {

                    customChronometer.stop();
                    Toast.makeText(getBaseContext(),"Reached the end.!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}
