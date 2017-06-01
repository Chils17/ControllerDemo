package com.webmyne.controllerdemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import com.webmyne.controllerdemo.R;

import java.util.ArrayList;

public class MultiAutoCompleteTextViewActivity extends AppCompatActivity {

    String[] androidVersionNames = {"Aestro", "Blender", "CupCake", "Donut", "Eclair", "Froyo",
            "Gingerbread", "HoneyComb", "IceCream Sandwich",
            "Jellibean", "Kitkat", "Lollipop", "MarshMallow"};
    private MultiAutoCompleteTextView simpleMultiAutoCompleteTextView;
    private MultiAutoCompleteTextView auto;
    private EditText et1;
    private Button b1;
    private ArrayList<String> li;
    private MultiAutoCompleteTextView multiAutoCompleteTvMonth;
    private ArrayAdapter<String> monthAdapter;
    private String[] months;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_auto_complete_text_view);

        li = new ArrayList<String>();

        li.clear();

        li.add("Item 1");
        li.add("Item 2");
        li.add("Item 3");

        init();

        clickListener();

        setAdapter();

        setLayoutAdapter();
    }

    private void init() {
        simpleMultiAutoCompleteTextView = (MultiAutoCompleteTextView) findViewById(R.id.simpleMultiAutoCompleteTextView);
        auto = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView1);
        et1 = (EditText) findViewById(R.id.editText1);
        b1 = (Button) findViewById(R.id.button1);

        multiAutoCompleteTvMonth = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTvMonth);

        add();
    }

    private void clickListener() {
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                li.add(et1.getText().toString());
                et1.setText(null);
                add();
                Toast.makeText(getBaseContext(), "Item Added", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void add() {
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, li);

        adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        auto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        auto.setThreshold(1);
        auto.setAdapter(adp);
    }

    private void setAdapter() {
        ArrayAdapter<String> versionNames = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, androidVersionNames);

        simpleMultiAutoCompleteTextView.setAdapter(versionNames);
        simpleMultiAutoCompleteTextView.setThreshold(1);
        simpleMultiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }

    private void setLayoutAdapter() {
        months = getResources().getStringArray(R.array.months);
        monthAdapter = new ArrayAdapter<String>(this, R.layout.hint_completion_layout, R.id.tvHintCompletion, months);

        multiAutoCompleteTvMonth.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        multiAutoCompleteTvMonth.setAdapter(monthAdapter);
    }
}
