package com.webmyne.controllerdemo.ui;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.webmyne.controllerdemo.R;

public class ButtonActivity extends AppCompatActivity {

    private Button btnOk;
    private boolean isButton = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);


        init();
    }

    private void init() {

    }
}
