package com.webmyne.controllerdemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterViewFlipper;

import com.webmyne.controllerdemo.R;
import com.webmyne.controllerdemo.adapter.CustomAdapter;
import com.webmyne.controllerdemo.adapter.MyViewFilpperAdapter;

public class AdapterViewFlipperActivity extends AppCompatActivity {
    String[] countryNames = {"India", "China", "Australia", "Portugle", "America", "New Zealand"};
    int flags[] = {R.drawable.india, R.drawable.china, R.drawable.australia, R.drawable.portugal, R.drawable.america, R.drawable.new_zealand};
    private AdapterViewFlipper simpleAdapterViewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_view_flipper);

        init();

        clickListener();

        setAdapter();
    }


    private void init() {
        simpleAdapterViewFlipper = (AdapterViewFlipper) findViewById(R.id.simpleAdapterViewFlipper);
    }

    private void clickListener() {

    }

    private void setAdapter() {
        MyViewFilpperAdapter myViewFilpperAdapter = new MyViewFilpperAdapter(getApplicationContext(), flags, countryNames);
        simpleAdapterViewFlipper.setAdapter(myViewFilpperAdapter);
        simpleAdapterViewFlipper.setFlipInterval(3000);
        simpleAdapterViewFlipper.setAutoStart(true);
    }
}
