package com.webmyne.controllerdemo.ui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.webmyne.controllerdemo.R;
import com.webmyne.controllerdemo.adapter.CustomAutoCompleteTextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AutoCompleteTextViewActivity extends AppCompatActivity {
    private String[] arr = {"Paries,France", "PA,United States", "Parana,Brazil",
            "Padua,Italy", "Pasadena,CA,United States"};

    String[] countries = new String[]{
            "India", "China", "Australia", "Portugle", "America", "New Zealand"};

    int[] flags = new int[]{
            R.drawable.india, R.drawable.china, R.drawable.australia, R.drawable.portugal, R.drawable.america, R.drawable.new_zealand};

    String[] currency = new String[]{
            "Indian Rupee", "China Rupee", "Australia Rupee", "Portugle Rupee", "America Rupee", "New Zealand Rupee"};
    private AutoCompleteTextView autoComplete;
    private CustomAutoCompleteTextView customAutoComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text_view);

        init();

        clickListener();

        setAdapter();

        setCustomAutoCompleteTextView();
    }


    private void init() {
        autoComplete = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        customAutoComplete = (CustomAutoCompleteTextView) findViewById(R.id.autocomplete);
    }

    private void setAdapter() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, arr);

        autoComplete.setThreshold(2);
        autoComplete.setAdapter(adapter);
        autoComplete.setTextColor(Color.RED);
    }


    private void clickListener() {
    }

    private void setCustomAutoCompleteTextView() {
        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 6; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("txt", countries[i]);
            hm.put("flag", Integer.toString(flags[i]));
            hm.put("cur", currency[i]);
            aList.add(hm);
        }

        String[] from = {"flag", "txt"};

        int[] to = {R.id.flag, R.id.txt};

        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.autocomplete_layout, from, to);

        customAutoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String, String> hm = (HashMap<String, String>) parent.getAdapter().getItem(position);

                TextView tvCurrency = (TextView) findViewById(R.id.tv_currency);

                tvCurrency.setText("Currency : " + hm.get("cur"));
            }
        });
        customAutoComplete.setAdapter(adapter);

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        TextView tvCurrency = (TextView) findViewById(R.id.tv_currency);
        outState.putString("currency", tvCurrency.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        TextView tvCurrency = (TextView) findViewById(R.id.tv_currency);
        tvCurrency.setText(savedInstanceState.getString("currency"));
        super.onRestoreInstanceState(savedInstanceState);
    }

}
