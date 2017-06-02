package com.webmyne.controllerdemo.ui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.webmyne.controllerdemo.R;

public class TextSwitcherActivity extends AppCompatActivity {
    private String textToShow[] = {"India", "China", "Australia", "Portugle", "America", "New Zealand"};
    private int messageCount = textToShow.length;
    private int currentIndex = -1;
    private Button btnNext;
    private TextSwitcher mSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_switcher);

        init();

        clickListener();

        setAnimation();
    }


    private void init() {
        btnNext = (Button) findViewById(R.id.buttonNext);
        mSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher);
    }

    private void clickListener() {
        mSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                TextView myText = new TextView(getApplicationContext());
                myText.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
                myText.setTextSize(36);
                myText.setTextColor(Color.BLACK);
                return myText;
            }
        });


        btnNext.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                currentIndex++;
                if (currentIndex == messageCount)
                    currentIndex = 0;
                mSwitcher.setText(textToShow[currentIndex]);
            }
        });
    }

    private void setAnimation() {
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        mSwitcher.setInAnimation(in);
        mSwitcher.setOutAnimation(out);

    }
}
