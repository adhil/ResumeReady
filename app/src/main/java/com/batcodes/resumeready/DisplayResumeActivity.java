package com.batcodes.resumeready;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayResumeActivity extends AppCompatActivity {

    // Declare Variables
    TextView mainTitle, name, mobile, email, gender, qual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_resume);

        mainTitle = (TextView) findViewById(R.id.mainTitle);
        name  = (TextView) findViewById(R.id.name);
        mobile = (TextView) findViewById(R.id.mobile);
        email = (TextView) findViewById(R.id.email);
        gender = (TextView) findViewById(R.id.gender);
        qual = (TextView) findViewById(R.id.qual);

        // Get intent passed by parent class
        // & Assign data to corresponding variables

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        mainTitle.setText("Welcome " + bundle.getString("name"));
        name.setText(bundle.getString("name"));
        mobile.setText(bundle.getString("mobile"));
        email.setText(bundle.getString("email"));
        gender.setText(bundle.getString("gender"));
        qual.setText(bundle.getString("qual"));
    }
}