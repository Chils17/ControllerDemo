package com.webmyne.controllerdemo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.webmyne.controllerdemo.R;
import com.webmyne.controllerdemo.SearchActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnEdit;
    private Button btnText;
    private Button btnImage;
    private Button btnRadio;
    private Button btnButton;
    private Button btnSearch;
    private Button btnSpinner;
    private Button btnToogle;
    private Button btnProgress;
    private Button btnSeek;
    private Button btnQCB;
    private Button btnAutoCompleteTextView;
    private Button btnMultiAutoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


    }

    private void init() {
        btnEdit = (Button) findViewById(R.id.btnEdit);
        btnText = (Button) findViewById(R.id.btnText);
        btnImage = (Button) findViewById(R.id.btnImage);
        btnRadio = (Button) findViewById(R.id.btnRadio);
        btnButton = (Button) findViewById(R.id.btnButton);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        btnSpinner = (Button) findViewById(R.id.btnSpinner);
        btnToogle = (Button) findViewById(R.id.btnToogle);
        btnProgress = (Button) findViewById(R.id.btnProgress);
        btnSeek = (Button) findViewById(R.id.btnSeek);
        btnQCB = (Button) findViewById(R.id.btnQCB);
        btnAutoCompleteTextView = (Button) findViewById(R.id.btnAutoCompleteTextView);
        btnMultiAutoTextView = (Button) findViewById(R.id.btnMultiAutoTextView);

        listener();
    }

    private void listener() {
        btnEdit.setOnClickListener(this);
        btnText.setOnClickListener(this);
        btnImage.setOnClickListener(this);
        btnRadio.setOnClickListener(this);
        btnButton.setOnClickListener(this);
        btnSearch.setOnClickListener(this);
        btnSpinner.setOnClickListener(this);
        btnToogle.setOnClickListener(this);
        btnProgress.setOnClickListener(this);
        btnSeek.setOnClickListener(this);
        btnQCB.setOnClickListener(this);
        btnAutoCompleteTextView.setOnClickListener(this);
        btnMultiAutoTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnEdit:
                Intent intentEdit = new Intent(this, EditActivity.class);
                startActivity(intentEdit);
                break;

            case R.id.btnText:
                Intent intentText = new Intent(this, TextActivity.class);
                startActivity(intentText);
                break;

            case R.id.btnImage:
                Intent intentImage = new Intent(this, ImageActivity.class);
                startActivity(intentImage);
                break;

            case R.id.btnRadio:
                Intent intentRadio = new Intent(this, RadioActivity.class);
                startActivity(intentRadio);
                break;

            case R.id.btnButton:
                Intent intentButton = new Intent(this, ButtonActivity.class);
                startActivity(intentButton);
                break;

            case R.id.btnSearch:
                Intent intentSearch = new Intent(this, SearchActivity.class);
                startActivity(intentSearch);
                break;

            case R.id.btnSpinner:
                Intent intentSpinner = new Intent(this, SpinnerActivity.class);
                startActivity(intentSpinner);
                break;

            case R.id.btnToogle:
                Intent intentToogle = new Intent(this, ToggleButtonActivity.class);
                startActivity(intentToogle);
                break;

            case R.id.btnProgress:
                Intent intentProgress = new Intent(this, ProgressBarActivity.class);
                startActivity(intentProgress);
                break;

            case R.id.btnSeek:
                Intent intentSeek = new Intent(this, SeekBarActivity.class);
                startActivity(intentSeek);
                break;

            case R.id.btnQCB:
                Intent intentQCB = new Intent(this, QuickContactActivity.class);
                startActivity(intentQCB);
                break;

            case R.id.btnAutoCompleteTextView:
                Intent intentAutoCompTxtView = new Intent(this, AutoCompleteTextViewActivity.class);
                startActivity(intentAutoCompTxtView);
                break;

            case R.id.btnMultiAutoTextView:
                Intent intentMultiAutoCompTxtView = new Intent(this, MultiAutoCompleteTextViewActivity.class);
                startActivity(intentMultiAutoCompTxtView);
                break;

        }

    }
}
