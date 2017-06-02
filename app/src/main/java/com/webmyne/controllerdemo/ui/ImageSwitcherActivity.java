package com.webmyne.controllerdemo.ui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.webmyne.controllerdemo.R;

public class ImageSwitcherActivity extends AppCompatActivity {

    private Button btnNext;
    private ImageSwitcher simpleImageSwitcher;

    private static final String[] TEXTS = { "India", "China", "Australia", "Portugle", "America", "New Zealand"};
    private static final int[] IMAGES = { R.drawable.india, R.drawable.china, R.drawable.australia, R.drawable.portugal, R.drawable.america, R.drawable.new_zealand};
    private int mPosition = 0;
    private TextSwitcher mTextSwitcher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_switcher);

        init();

        clickListener();

        setAnimation();
    }


    private void init() {
        btnNext = (Button) findViewById(R.id.btnNext);
        simpleImageSwitcher = (ImageSwitcher) findViewById(R.id.simpleImageSwitcher);
        mTextSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher);
    }

    private void clickListener() {
        simpleImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());

                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
                return imageView;
            }
        });


        mTextSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getApplicationContext());
                textView.setTextSize(18);
                textView.setTextColor(Color.BLACK);
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });


        btnNext.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                mTextSwitcher.setText(TEXTS[mPosition]);
                simpleImageSwitcher.setBackgroundResource(IMAGES[mPosition]);
                mPosition = (mPosition + 1) % TEXTS.length;
            }
        });

    }

    private void setAnimation() {

        mTextSwitcher.setInAnimation(this, android.R.anim.fade_in);
        mTextSwitcher.setOutAnimation(this, android.R.anim.fade_out);

        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        simpleImageSwitcher.setInAnimation(in);
        simpleImageSwitcher.setOutAnimation(out);

    }

}
