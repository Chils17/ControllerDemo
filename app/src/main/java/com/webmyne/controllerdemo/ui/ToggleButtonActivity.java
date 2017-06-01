package com.webmyne.controllerdemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.webmyne.controllerdemo.R;

public class ToggleButtonActivity extends AppCompatActivity {

    private ToggleButton simpleToggleButton1, simpleToggleButton2;
    private Button submit;
    private ToggleButton tbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button);

        init();

        clickListener();
    }

    private void init() {
        simpleToggleButton1 = (ToggleButton) findViewById(R.id.simpleToggleButton1);
        simpleToggleButton2 = (ToggleButton) findViewById(R.id.simpleToggleButton2);
        tbutton = (ToggleButton) findViewById(R.id.toggleButton1);
        submit = (Button) findViewById(R.id.submitButton);
    }


    private void clickListener() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String status = "ToggleButton1 : " + simpleToggleButton1.getText() + "\n" + "ToggleButton2 : " + simpleToggleButton2.getText();
                Toast.makeText(getApplicationContext(), status, Toast.LENGTH_SHORT).show();
            }
        });

        tbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tbutton.isChecked()) {
                    Toast.makeText(ToggleButtonActivity.this, "Toggle button is on", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ToggleButtonActivity.this, "Toggle button is Off", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}
