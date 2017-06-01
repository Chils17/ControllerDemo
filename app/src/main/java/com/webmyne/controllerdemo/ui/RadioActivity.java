package com.webmyne.controllerdemo.ui;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.webmyne.controllerdemo.R;

public class RadioActivity extends AppCompatActivity {

    private RadioButton radioMan;
    private RadioButton radioFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

        init();
    }

    private void init() {
        radioMan = (RadioButton) findViewById(R.id.radioMan);
        radioFemale = (RadioButton) findViewById(R.id.radioFemale);
        radioMan.setButtonDrawable(R.drawable.ic_man);
        radioFemale.setButtonDrawable(R.drawable.ic_female);

        listener();

    }

    private void listener() {
        radioMan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    radioMan.setTextColor(ContextCompat.getColor(RadioActivity.this, R.color.colorPurple));
                } else {
                    radioMan.setTextColor(ContextCompat.getColor(RadioActivity.this, R.color.colorPrimary));
                }
            }
        });


        radioFemale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    radioFemale.setTextColor(ContextCompat.getColor(RadioActivity.this, R.color.colorPurple));
                } else {
                    radioFemale.setTextColor(ContextCompat.getColor(RadioActivity.this, R.color.colorPrimary));
                }
            }
        });
    }
}
