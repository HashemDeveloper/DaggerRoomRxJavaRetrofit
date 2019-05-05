package com.practice.practicemvvm.model.raxi;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BoundsNE implements Parcelable {

    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lon")
    @Expose
    private Double lon;
    public final static Parcelable.Creator<BoundsNE> CREATOR = new Creator<BoundsNE>() {
        @SuppressWarnings({
                "unchecked"
        })
        public BoundsNE createFromParcel(Parcel in) {
            return new BoundsNE(in);
        }

        public BoundsNE[] newArray(int size) {
            return (new BoundsNE[size]);
        }
    };

    protected BoundsNE(Parcel in) {
        this.lat = ((Double) in.readValue((Double.class.getClassLoader())));
        this.lon = ((Double) in.readValue((Double.class.getClassLoader())));
    }

    public BoundsNE() {
    }

    public BoundsNE(Double lat, Double lon) {
        super();
        this.lat = lat;
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(lat);
        dest.writeValue(lon);
    }

    public int describeContents() {
        return 0;
    }

}
