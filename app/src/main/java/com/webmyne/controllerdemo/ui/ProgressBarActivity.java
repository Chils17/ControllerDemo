package com.webmyne.controllerdemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.webmyne.controllerdemo.R;

public class ProgressBarActivity extends AppCompatActivity {

    private ProgressBar firstBar;
    private ProgressBar secondBar;
    private Button myButton;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        init();

        clickListener();
    }

    private void init() {
        firstBar = (ProgressBar) findViewById(R.id.firstBar);
        secondBar = (ProgressBar) findViewById(R.id.secondBar);
        myButton = (Button) findViewById(R.id.myButton);
    }

    private void clickListener() {
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0 || i == 10) {
                    //make the progress bar visible
                    firstBar.setVisibility(View.VISIBLE);
                    firstBar.setMax(150);
                    secondBar.setVisibility(View.VISIBLE);
                } else if (i < firstBar.getMax()) {
                    //Set first progress bar value
                    firstBar.setProgress(i);
                    //Set the second progress bar value
                    firstBar.setSecondaryProgress(i + 10);
                } else {

                    firstBar.setProgress(0);

                    firstBar.setSecondaryProgress(0);

                    i = 0;
                    firstBar.setVisibility(View.GONE);
                    secondBar.setVisibility(View.GONE);
                }
                i = i + 10;
            }
        });
    }
}
