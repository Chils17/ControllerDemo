package com.webmyne.controllerdemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.webmyne.controllerdemo.R;
import com.webmyne.controllerdemo.adapter.CustomAdapter;
import com.webmyne.controllerdemo.adapter.CustomSpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity {
    private Spinner spinnerCountry, spinnerCity;
    private Spinner spinner;
    String[] countryNames = {"India", "China", "Australia", "Portugle", "America", "New Zealand"};
    int flags[] = {R.drawable.india, R.drawable.china, R.drawable.australia, R.drawable.portugal, R.drawable.america, R.drawable.new_zealand};
    private Spinner spin;
    private Spinner spinCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        init();

        initCustomSpinner();

        clickListener();

    }

    private void initCustomSpinner() {
        spinCustom = (Spinner) findViewById(R.id.spinCustom);

        ArrayList<String> languages = new ArrayList<String>();
        languages.add("India");
        languages.add("Canada");
        languages.add("America");
        languages.add("New ZeaLand");
        languages.add("China");
        CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter(SpinnerActivity.this, languages);
        spinCustom.setAdapter(customSpinnerAdapter);
        spinCustom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String item = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    private void init() {
        spinner = (Spinner) findViewById(R.id.spinner);
        spin = (Spinner) findViewById(R.id.simpleSpinner);
        spinnerCountry = (Spinner) findViewById(R.id.spinnerCountry);
        spinnerCity = (Spinner) findViewById(R.id.spinnerCity);

    }

    private void clickListener() {
        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                parent.getItemAtPosition(position);

                if (position == 0) {
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter
                            .createFromResource(getApplicationContext(), R.array.city_india,
                                    android.R.layout.simple_spinner_item);
                    spinnerCity.setAdapter(adapter);

                } else if (position == 1) {
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter
                            .createFromResource(getApplicationContext(), R.array.city_canada,
                                    android.R.layout.simple_spinner_item);
                    spinnerCity.setAdapter(adapter);

                } else if (position == 2) {
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter
                            .createFromResource(getApplicationContext(), R.array.city_srilanka,
                                    android.R.layout.simple_spinner_item);
                    spinnerCity.setAdapter(adapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        // Spinner click listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // On selecting a spinner item
                String item = parent.getItemAtPosition(position).toString();

                // Showing selected spinner item
                Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), countryNames[position], Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        setAdapter();
    }

    private void setAdapter() {
        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Automobile");
        categories.add("Business Services");
        categories.add("Computers");
        categories.add("Education");
        categories.add("Personal");
        categories.add("Travel");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);


        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), flags, countryNames);
        spin.setAdapter(customAdapter);

    }


}
