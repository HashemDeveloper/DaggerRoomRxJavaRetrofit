package com.practice.practicemvvm.validators;

import com.google.android.material.textfield.TextInputLayout;

public class BaseInputValidator {

    private TextInputLayout inputLayout;

    String mEmptyMessage = "";
    String mErrorMessage = "";

    BaseInputValidator(TextInputLayout inputLayout){

        this.inputLayout = inputLayout;
    }

    protected boolean isValid(CharSequence charSequence){

        return true;
    }

    public boolean validate(CharSequence charSequence){

        if(this.mEmptyMessage != null && (charSequence == null) || charSequence.length() == 0){


            this.inputLayout.setError(this.mEmptyMessage);

            return false;

        }else if(isValid(charSequence)){

            this.inputLayout.setError("");
            return true;

        }else{

            this.inputLayout.setError(this.mErrorMessage);
            return false;
        }
    }
}
