package com.webmyne.controllerdemo.ui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.StackView;

import com.webmyne.controllerdemo.R;
import com.webmyne.controllerdemo.adapter.StackAdapter;
import com.webmyne.controllerdemo.model.StackItem;

import java.util.ArrayList;
import java.util.List;

public class StackViewActivity extends AppCompatActivity {
    private final String[] IMAGE_NAMES = {"india", "china", "australia", "portugal", "america","new_zealand" };
    private StackView stackView;
    private Button buttonNext;
    private Button buttonPrevious;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_view);

        init();

        clickListener();

        setAdapter();
    }


    private void init() {
        stackView = (StackView) findViewById(R.id.stackView);
        buttonNext = (Button) findViewById(R.id.button_next);
        buttonPrevious = (Button) findViewById(R.id.button_previous);
    }

    private void clickListener() {
        buttonNext.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                stackView.showNext();
            }
        });

        buttonPrevious.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                stackView.showPrevious();
            }
        });
    }

    private void setAdapter() {
        List<StackItem> items = new ArrayList<StackItem>();

        for (String imageName : IMAGE_NAMES) {
            items.add(new StackItem(imageName + ".png", imageName));
        }

        StackAdapter adapt = new StackAdapter(this, R.layout.stack_item, items);
        stackView.setAdapter(adapt);
        stackView.setHorizontalScrollBarEnabled(true);
        stackView.setBackgroundColor(Color.rgb(230, 255, 255));
    }
}
