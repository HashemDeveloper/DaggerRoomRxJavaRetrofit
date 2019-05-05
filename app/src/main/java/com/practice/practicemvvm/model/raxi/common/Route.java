package com.practice.practicemvvm.model.raxi.common;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.practice.practicemvvm.model.raxi.BoundsNE;

public class Route implements Parcelable {

    @SerializedName("pointsEncoded")
    @Expose
    private String pointsEncoded;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("distance")
    @Expose
    private Integer distance;
    @SerializedName("waypointsEncoded")
    @Expose
    private String waypointsEncoded;
    @SerializedName("boundsSW")
    @Expose
    private BoundsSW boundsSW;
    @SerializedName("boundsNE")
    @Expose
    private BoundsNE boundsNE;
    public final static Parcelable.Creator<Route> CREATOR = new Creator<Route>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Route createFromParcel(Parcel in) {
            return new Route(in);
        }

        public Route[] newArray(int size) {
            return (new Route[size]);
        }

    }
            ;

    protected Route(Parcel in) {
        this.pointsEncoded = ((String) in.readValue((String.class.getClassLoader())));
        this.duration = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.distance = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.waypointsEncoded = ((String) in.readValue((String.class.getClassLoader())));
        this.boundsSW = ((BoundsSW) in.readValue((BoundsSW.class.getClassLoader())));
        this.boundsNE = ((BoundsNE) in.readValue((BoundsNE.class.getClassLoader())));
    }

    public Route() {
    }

    public Route(String pointsEncoded, Integer duration, Integer distance, String waypointsEncoded, BoundsSW boundsSW, BoundsNE boundsNE) {
        super();
        this.pointsEncoded = pointsEncoded;
        this.duration = duration;
        this.distance = distance;
        this.waypointsEncoded = waypointsEncoded;
        this.boundsSW = boundsSW;
        this.boundsNE = boundsNE;
    }

    public String getPointsEncoded() {
        return pointsEncoded;
    }

    public void setPointsEncoded(String pointsEncoded) {
        this.pointsEncoded = pointsEncoded;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String getWaypointsEncoded() {
        return waypointsEncoded;
    }

    public void setWaypointsEncoded(String waypointsEncoded) {
        this.waypointsEncoded = waypointsEncoded;
    }

    public BoundsSW getBoundsSW() {
        return boundsSW;
    }

    public void setBoundsSW(BoundsSW boundsSW) {
        this.boundsSW = boundsSW;
    }

    public BoundsNE getBoundsNE() {
        return boundsNE;
    }

    public void setBoundsNE(BoundsNE boundsNE) {
        this.boundsNE = boundsNE;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(pointsEncoded);
        dest.writeValue(duration);
        dest.writeValue(distance);
        dest.writeValue(waypointsEncoded);
        dest.writeValue(boundsSW);
        dest.writeValue(boundsNE);
    }

    public int describeContents() {
        return 0;
    }
}