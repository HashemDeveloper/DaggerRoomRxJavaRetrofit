package com.practice.practicemvvm.constants;

import android.util.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Constants {

    public static boolean emailValidator(String email){

        Pattern pattern;
        Matcher matcher;

        String EMAIL_PATTERN = Patterns.EMAIL_ADDRESS.pattern();
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
