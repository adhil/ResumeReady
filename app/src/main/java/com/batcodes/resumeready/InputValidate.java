package com.batcodes.resumeready;

import android.text.TextUtils;
import android.util.Patterns;

/**
 * Created by adhil on 18/9/17.
 * Helper class to validate input data
 */

public class InputValidate {

    /* Method to validate input Name
    *
    *  Returns - 'true' if 'Name' is not null
    *  Returns - 'false' if 'Name' is null
    * */
    public static boolean isValidName(String name) {
        return !name.isEmpty();
    }

    /* Method to validate input Email
    *
    *  Returns - 'true' if 'Email' is not null
    *               & valid format
    *  Returns - 'false' if 'Email' is null
    *               or invalid format
    * */
    public static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    /* Method to validate input Mobile
    *
    *  Returns - 'true' if 'Mobile' is not null
    *               & valid format
    *  Returns - 'false' if 'Mobile' is null
    *               or invalid format
    * */
    public static boolean isValidMobile(String mobile) {
        return !TextUtils.isEmpty(mobile) && Patterns.PHONE.matcher(mobile).matches();
    }
}