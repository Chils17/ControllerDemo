package com.webmyne.controllerdemo.ui;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.webmyne.controllerdemo.R;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtPass;
    private EditText edtConPass;
    private Button btnSignIn;
    private EditText editPassword;
    private ImageView img;
    private boolean isEye = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        init();
    }

    private void init() {
        edtPass = (EditText) findViewById(R.id.edtPass);
        edtConPass = (EditText) findViewById(R.id.edtConPass);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        editPassword = (EditText) findViewById(R.id.editPassword);
        img = (ImageView) findViewById(R.id.img);
        img.setBackgroundResource(R.drawable.ic_eye);

        btnSignIn.setOnClickListener(this);
        img.setOnClickListener(this);

        editPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >=
                            (editPassword.getRight() - editPassword.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        if (isEye) {
                            editPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_eye, 0);
                            // img.setBackgroundColor(ContextCompat.getColor(EditActivity.this, R.color.colorOrange));
                            isEye = false;
                        } else {
                            editPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_black_eye, 0);
                            //img.setBackgroundColor(ContextCompat.getColor(EditActivity.this, R.color.colorPrimary));
                            isEye = true;
                        }

                        return true;
                    }
                }
                return false;
            }
        });


    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnSignIn:
                String psw = edtPass.getText().toString();
                String cpsw = edtConPass.getText().toString();
                checkPassWordAndConfirmPassword(psw, cpsw);
                break;

            case R.id.img:
                if (isEye) {
                    img.setBackgroundResource(R.drawable.ic_eye);
                    // img.setBackgroundColor(ContextCompat.getColor(EditActivity.this, R.color.colorOrange));
                    isEye = false;
                } else {
                    img.setBackgroundResource(R.drawable.ic_black_eye);
                    //img.setBackgroundColor(ContextCompat.getColor(EditActivity.this, R.color.colorPrimary));
                    isEye = true;
                }
                break;
        }


    }


    public boolean checkPassWordAndConfirmPassword(String password, String confirmPassword) {
        boolean pstatus = false;
        if (!password.isEmpty() && !confirmPassword.isEmpty()) {
            if (password.equals(confirmPassword)) {
                Toast.makeText(this, "matched !", Toast.LENGTH_SHORT).show();
                pstatus = true;
            } else {
                Toast.makeText(this, "Password is not matched !", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Fileds are empty !", Toast.LENGTH_SHORT).show();
        }
        return pstatus;
    }
}
