package com.practice.practicemvvm.base;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import org.threeten.bp.ZonedDateTime;

public class ZonedDateTimeAdapter {


    // deserializing from string to object
    @FromJson
    ZonedDateTime fromJson(String json){

        return ZonedDateTime.parse(json);
    }

    // serializing from object to string

    @ToJson
    String toJson(ZonedDateTime value){

        if(value != null){

            return value.toString();

        }else{

            return null;
        }
    }
}
