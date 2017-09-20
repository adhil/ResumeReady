package com.batcodes.resumeready;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class FormStartActivity extends AppCompatActivity {

    // Declare Variables
    EditText nameField, mobileField, emailField;
    TextInputLayout nameLayout, mobileLayout, emailLayout;
    RadioGroup genderOption;
    RadioButton maleOpt, femaleOpt;
    String name, mobile, email, gender; // variables to be passed to next screen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_start);

        // Initialize all variables
        nameLayout = (TextInputLayout) findViewById(R.id.input_layout_name);
        mobileLayout = (TextInputLayout) findViewById(R.id.input_layout_mobile);
        emailLayout = (TextInputLayout) findViewById(R.id.input_layout_email);
        nameField = (EditText) findViewById(R.id.name_field);
        mobileField = (EditText) findViewById(R.id.mobile_field);
        emailField = (EditText) findViewById(R.id.email_field);
        genderOption = (RadioGroup) findViewById(R.id.genderOption);
        maleOpt = (RadioButton) findViewById(R.id.maleOption);
        femaleOpt = (RadioButton) findViewById(R.id.femaleOption);
        gender = "male"; // Default value for Radio Group
    }

    // Button Click Listener
    public void proceedFun(View view) {
        getDetails();
        nextScreen();
    }

    /* Method to extract input values from EditText fields
    *  & initialize variables
    * */
    private void getDetails() {
        name = nameField.getText().toString();
        mobile = mobileField.getText().toString();
        email = emailField.getText().toString();
    }

    // RadioGroup Click Listener
    public void selectGender(View view) {
        int id = genderOption.getCheckedRadioButtonId();

        switch (id) {
            case R.id.maleOption : gender = "Male";
                break;
            case R.id.femaleOption : gender = "Female";
        }
    }

    /* Method to create intent
    *  & add data to the bundle
    * */
    private void nextScreen() {

        if (isValidInput()) {
            Intent intent = new Intent(FormStartActivity.this, FormSecondActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("mobile", mobile);
            intent.putExtra("email", email);
            intent.putExtra("gender", gender);
            startActivity(intent);
        }
    }

    /* Method to validate the input values extracted from EditText Fields
    *
    *  Returns - 'true' if all inputs are valid
    *  Returns - 'false' if any inputs are empty or invalid
    *             & displays error message on corresponding fields
    * */

    private boolean isValidInput(){

        name = nameField.getText().toString().trim();
        email = emailField.getText().toString().trim();
        mobile = mobileField.getText().toString().trim();

        boolean isInputValid = true;

        if (!InputValidate.isValidMobile(mobile)) {
            mobileLayout.setError(getString(R.string.err_msg_mobile));
            isInputValid = false;
        } else {
            emailLayout.setErrorEnabled(false);
        }
        if (!InputValidate.isValidEmail(email)) {
            emailLayout.setError(getString(R.string.err_msg_email));
            isInputValid = false;
        } else {
            emailLayout.setErrorEnabled(false);
        }
        if (!InputValidate.isValidName(name)) {
            nameLayout.setError(getString(R.string.err_msg_name));
            isInputValid =false;
        } else {
            nameLayout.setErrorEnabled(false);
        }

        return isInputValid;
    }
}