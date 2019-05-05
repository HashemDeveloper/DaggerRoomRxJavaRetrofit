package com.practice.practicemvvm.model.raxi;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.practice.practicemvvm.model.raxi.common.BoundsNE_;
import com.practice.practicemvvm.model.raxi.common.BoundsSW_;
import com.practice.practicemvvm.model.raxi.common.Route;

import java.util.List;

public class RouteResponse implements Parcelable {

    @SerializedName("routes")
    @Expose
    private List<Route> routes = null;
    @SerializedName("boundsSW")
    @Expose
    private BoundsSW_ boundsSW;
    @SerializedName("boundsNE")
    @Expose
    private BoundsNE_ boundsNE;
    @SerializedName("source")
    @Expose
    private String source;
    public final static Parcelable.Creator<RouteResponse> CREATOR = new Creator<RouteResponse>() {
        @SuppressWarnings({
                "unchecked"
        })
        public RouteResponse createFromParcel(Parcel in) {
            return new RouteResponse(in);
        }

        public RouteResponse[] newArray(int size) {
            return (new RouteResponse[size]);
        }
    };

    protected RouteResponse(Parcel in) {
        in.readList(this.routes, (Route.class.getClassLoader()));
        this.boundsSW = ((BoundsSW_) in.readValue((BoundsSW_.class.getClassLoader())));
        this.boundsNE = ((BoundsNE_) in.readValue((BoundsNE_.class.getClassLoader())));
        this.source = ((String) in.readValue((String.class.getClassLoader())));
    }
    public RouteResponse() {
    }

    public RouteResponse(List<Route> routes, BoundsSW_ boundsSW, BoundsNE_ boundsNE, String source) {
        super();
        this.routes = routes;
        this.boundsSW = boundsSW;
        this.boundsNE = boundsNE;
        this.source = source;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public BoundsSW_ getBoundsSW() {
        return boundsSW;
    }

    public void setBoundsSW(BoundsSW_ boundsSW) {
        this.boundsSW = boundsSW;
    }

    public BoundsNE_ getBoundsNE() {
        return boundsNE;
    }

    public void setBoundsNE(BoundsNE_ boundsNE) {
        this.boundsNE = boundsNE;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(routes);
        dest.writeValue(boundsSW);
        dest.writeValue(boundsNE);
        dest.writeValue(source);
    }

    public int describeContents() {
        return 0;
    }
}