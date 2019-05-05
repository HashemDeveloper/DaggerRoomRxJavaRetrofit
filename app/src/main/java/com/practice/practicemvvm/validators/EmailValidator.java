package com.practice.practicemvvm.validators;

import com.google.android.material.textfield.TextInputLayout;
import com.practice.practicemvvm.constants.Constants;

public class EmailValidator extends BaseInputValidator {


    public EmailValidator(TextInputLayout inputLayout) {
        super(inputLayout);

        mEmptyMessage = "Email is required";
        mErrorMessage = "Invalid email";
    }

    @Override
    protected boolean isValid(CharSequence charSequence) {


        String email = charSequence.toString();

        return Constants.emailValidator(email);
    }
}
