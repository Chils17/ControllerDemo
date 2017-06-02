package com.webmyne.controllerdemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewSwitcher;

import com.webmyne.controllerdemo.R;

public class ViewSwitcherActivity extends AppCompatActivity {

    private Button btnNext;
    private ViewSwitcher simpleViewSwitcher;
    private Button btnPrev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_switcher);

        init();

        clickListener();

        setAnimation();
    }

    private void init() {
        btnNext = (Button) findViewById(R.id.btnViewNext);
        btnPrev = (Button) findViewById(R.id.btnViewPrev);
        simpleViewSwitcher = (ViewSwitcher) findViewById(R.id.simpleViewSwitcher);
    }

    private void clickListener() {

        btnNext.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                simpleViewSwitcher.showNext();
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                simpleViewSwitcher.showPrevious();
            }
        });
    }

    private void setAnimation() {
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        simpleViewSwitcher.setInAnimation(in);
        simpleViewSwitcher.setOutAnimation(out);
    }
}
