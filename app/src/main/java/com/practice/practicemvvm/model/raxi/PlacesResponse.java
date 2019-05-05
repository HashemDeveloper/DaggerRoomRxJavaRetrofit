package com.practice.practicemvvm.model.raxi;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.practice.practicemvvm.model.raxi.common.BoundsSW;
import com.practice.practicemvvm.model.raxi.common.Coord;

public class PlacesResponse implements Parcelable {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("addressString")
    @Expose
    private String addressString;
    @SerializedName("osmPlaceId")
    @Expose
    private String osmPlaceId;
    @SerializedName("coord")
    @Expose
    private Coord coord;

    @SerializedName("boundsSW")
    @Expose
    private BoundsSW boundsSW;
    @SerializedName("boundsNE")
    @Expose
    private BoundsNE boundsNE;
    @SerializedName("nameOfPlace")
    @Expose
    private String nameOfPlace;
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("town")
    @Expose
    private String town;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("countryCd")
    @Expose
    private String countryCd;
    @SerializedName("building")
    @Expose
    private String building;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("stateCd")
    @Expose
    private String stateCd;
    @SerializedName("zip")
    @Expose
    private String zip;
    @SerializedName("county")
    @Expose
    private String county;
    @SerializedName("details")
    @Expose
    private Boolean details;
    public final static Parcelable.Creator<PlacesResponse> CREATOR = new Creator<PlacesResponse>() {
        @SuppressWarnings({
                "unchecked"
        })
        public PlacesResponse createFromParcel(Parcel in) {
            return new PlacesResponse(in);
        }

        public PlacesResponse[] newArray(int size) {
            return (new PlacesResponse[size]);
        }
    };

    protected PlacesResponse(Parcel in) {
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.addressString = ((String) in.readValue((String.class.getClassLoader())));
        this.osmPlaceId = ((String) in.readValue((String.class.getClassLoader())));
        this.coord = ((Coord) in.readValue((Coord.class.getClassLoader())));
        this.boundsSW = ((BoundsSW) in.readValue((BoundsSW.class.getClassLoader())));
        this.boundsNE = ((BoundsNE) in.readValue((BoundsNE.class.getClassLoader())));
        this.nameOfPlace = ((String) in.readValue((String.class.getClassLoader())));
        this.street = ((String) in.readValue((String.class.getClassLoader())));
        this.town = ((String) in.readValue((String.class.getClassLoader())));
        this.country = ((String) in.readValue((String.class.getClassLoader())));
        this.countryCd = ((String) in.readValue((String.class.getClassLoader())));
        this.building = ((String) in.readValue((String.class.getClassLoader())));
        this.state = ((String) in.readValue((String.class.getClassLoader())));
        this.stateCd = ((String) in.readValue((String.class.getClassLoader())));
        this.zip = ((String) in.readValue((String.class.getClassLoader())));
        this.county = ((String) in.readValue((String.class.getClassLoader())));
        this.details = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public PlacesResponse() {
    }

    public PlacesResponse(String type, String addressString, String osmPlaceId, Coord coord, BoundsSW boundsSW,
                          BoundsNE boundsNE, String nameOfPlace, String street, String town, String country,
                          String countryCd, String building, String state, String stateCd, String zip, String county, Boolean details) {
        super();
        this.type = type;
        this.addressString = addressString;
        this.osmPlaceId = osmPlaceId;
        this.coord = coord;
        this.boundsSW = boundsSW;
        this.boundsNE = boundsNE;
        this.nameOfPlace = nameOfPlace;
        this.street = street;
        this.town = town;
        this.country = country;
        this.countryCd = countryCd;
        this.building = building;
        this.state = state;
        this.stateCd = stateCd;
        this.zip = zip;
        this.county = county;
        this.details = details;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddressString() {
        return addressString;
    }

    public void setAddressString(String addressString) {
        this.addressString = addressString;
    }

    public String getOsmPlaceId(){
        return this.osmPlaceId;
    }

    public void setOsmPlaceId(String osmPlaceId){
        this.osmPlaceId = osmPlaceId;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
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

    public String getNameOfPlace() {
        return nameOfPlace;
    }

    public void setNameOfPlace(String nameOfPlace) {
        this.nameOfPlace = nameOfPlace;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCd() {
        return countryCd;
    }

    public void setCountryCd(String countryCd) {
        this.countryCd = countryCd;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateCd() {
        return stateCd;
    }

    public void setStateCd(String stateCd) {
        this.stateCd = stateCd;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Boolean getDetails() {
        return details;
    }

    public void setDetails(Boolean details) {
        this.details = details;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(type);
        dest.writeValue(addressString);
        dest.writeValue(osmPlaceId);
        dest.writeValue(coord);
        dest.writeValue(boundsSW);
        dest.writeValue(boundsNE);
        dest.writeValue(nameOfPlace);
        dest.writeValue(street);
        dest.writeValue(town);
        dest.writeValue(country);
        dest.writeValue(countryCd);
        dest.writeValue(building);
        dest.writeValue(state);
        dest.writeValue(stateCd);
        dest.writeValue(zip);
        dest.writeValue(county);
        dest.writeValue(details);
    }

    public int describeContents() {
        return 0;
    }
}