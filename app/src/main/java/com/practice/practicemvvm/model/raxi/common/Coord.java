package com.practice.practicemvvm.model.raxi.common;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Coord implements Parcelable {

    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lon")
    @Expose
    private Double lon;
    public final static Parcelable.Creator<Coord> CREATOR = new Creator<Coord>() {

        @SuppressWarnings({
                "unchecked"
        })
        public Coord createFromParcel(Parcel in) {
            return new Coord(in);
        }

        public Coord[] newArray(int size) {
            return (new Coord[size]);
        }
    };

    protected Coord(Parcel in) {
        this.lat = ((Double) in.readValue((Double.class.getClassLoader())));
        this.lon = ((Double) in.readValue((Double.class.getClassLoader())));
    }

    public Coord() {
    }

    public Coord(Double lat, Double lon) {
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
