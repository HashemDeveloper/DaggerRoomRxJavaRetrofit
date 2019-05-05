package com.practice.practicemvvm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountryInfo implements Parcelable {

    @SerializedName("RestResponse")
    @Expose
    private RestResponse restResponse;
    public final static Parcelable.Creator<CountryInfo> CREATOR = new Creator<CountryInfo>() {


        @SuppressWarnings({
                "unchecked"
        })
        public CountryInfo createFromParcel(Parcel in) {
            return new CountryInfo(in);
        }

        public CountryInfo[] newArray(int size) {
            return (new CountryInfo[size]);
        }

    }
            ;

    protected CountryInfo(Parcel in) {
        this.restResponse = ((RestResponse) in.readValue((RestResponse.class.getClassLoader())));
    }

    public CountryInfo() {
    }

    public CountryInfo(RestResponse restResponse) {
        super();
        this.restResponse = restResponse;
    }

    public RestResponse getRestResponse() {
        return restResponse;
    }

    public void setRestResponse(RestResponse restResponse) {
        this.restResponse = restResponse;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(restResponse);
    }

    public int describeContents() {
        return 0;
    }
}
