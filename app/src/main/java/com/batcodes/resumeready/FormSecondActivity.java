package com.batcodes.resumeready;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import android.widget.TextView;

public class FormSecondActivity extends AppCompatActivity {

    // Declare Variables
    TextView mainTitle;
    CheckBox bTechCheck, bcaCheck, mcaCheck, mbaCheck;
    EditText otherField;
    String name, mobile, email, gender, qual; // Data to be passed to the next screen
    Boolean isBtech = false, isBCA = false , isMCA = false, isMBA = false, isOther = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_second);

        // Initialize Variables
        otherField = (EditText) findViewById(R.id.otherField);
        mainTitle = (TextView) findViewById(R.id.mainTitle);
        bTechCheck = (CheckBox) findViewById(R.id.btechCheck);
        bcaCheck = (CheckBox) findViewById(R.id.bcaCheck);
        mcaCheck = (CheckBox) findViewById(R.id.mcaCheck);
        mbaCheck = (CheckBox) findViewById(R.id.mbaCheck);

        // Get intent passed by parent class
        // & Assign data to corresponding variables
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        name = bundle.getString("name");
        mobile = bundle.getString("mobile");
        email = bundle.getString("email");
        gender = bundle.getString("gender");

        mainTitle.setText("Welcome " + name);
    }

    // Button Click Listener
    public void proceedFun(View view) {
        getQual();
        nextScreen();
    }

    // CheckBox Click Listener
    public void selectQual(View view) {
        CheckBox checkBox = (CheckBox) view;
        Boolean isSelected = checkBox.isChecked();

        switch (view.getId()) {
            case R.id.btechCheck: if (isSelected) {
                isBtech = true;
            } else {
                isBtech = false;
            }
            break;

            case R.id.bcaCheck: if (isSelected) {
                isBCA = true;
            } else {
                isBCA =false;
            }
            break;

            case R.id.mcaCheck: if (isSelected) {
                isMCA = true;
            } else {
                isMCA = false;
            }
            break;

            case R.id.mbaCheck: if (isSelected) {
                isMBA =true;
            } else {
                isMBA = false;
            }
            break;

            case R.id.otherCheck: if (isSelected) {
                isOther = true;
                otherField.requestFocus();
            } else {
                isOther = false;
            }
        }
    }

    /* Method to set qualification according to the selected CheckBox
    * */
    public void getQual() {
        if (isBtech) {
            qual = bTechCheck.getText().toString();
        }

        if (isBCA) {
            qual = bcaCheck.getText().toString();
        }

        if (isMCA) {
            qual = mcaCheck.getText().toString();
        }

        if (isMBA) {
            qual = mbaCheck.getText().toString();
        }

        if (isOther) {
            qual = otherField.getText().toString();
        }
    }

    /* Method to create intent
    *  & add data to the bundle
    * */
    public void nextScreen(){
        Intent intent = new Intent(FormSecondActivity.this, DisplayResumeActivity.class);

        intent.putExtra("name", name);
        intent.putExtra("mobile", mobile);
        intent.putExtra("email", email);
        intent.putExtra("gender", gender);
        intent.putExtra("qual", qual);
        startActivity(intent);
    }
}
