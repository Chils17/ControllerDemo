package com.webmyne.controllerdemo.ui;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import com.webmyne.controllerdemo.R;

public class QuickContactActivity extends AppCompatActivity {

    private TextView Email;
    private TextView Phone;
    private QuickContactBadge EmailPic;
    private QuickContactBadge PhonePic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_contact);

        init();

        clickListener();
    }

    private void init() {

        Email = (TextView)findViewById(R.id.textView1);
        Phone = (TextView)findViewById(R.id.textView2);
        EmailPic = (QuickContactBadge)findViewById(R.id.quickContactBadge1);
        PhonePic = (QuickContactBadge)findViewById(R.id.quickContactBadge2);

        //Assign the contact badge to Email Pick badge.

        EmailPic.assignContactFromEmail("android@examples.com", true);
        EmailPic.setMode(ContactsContract.QuickContact.MODE_MEDIUM);

        //Assign the contact badge to phone pick badge.

        PhonePic.assignContactFromPhone("+911234567890", true);
        PhonePic.setMode(ContactsContract.QuickContact.MODE_MEDIUM);

    }

    private void clickListener() {

    }
}
