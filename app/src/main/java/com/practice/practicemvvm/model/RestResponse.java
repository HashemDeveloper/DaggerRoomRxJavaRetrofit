package com.practice.practicemvvm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RestResponse implements Parcelable
{

    @SerializedName("messages")
    @Expose
    private List<String> messages = null;
    @SerializedName("result")
    @Expose
    private List<Result> result = null;
    public final static Parcelable.Creator<RestResponse> CREATOR = new Creator<RestResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public RestResponse createFromParcel(Parcel in) {
            return new RestResponse(in);
        }

        public RestResponse[] newArray(int size) {
            return (new RestResponse[size]);
        }

    }
            ;

    protected RestResponse(Parcel in) {
        in.readList(this.messages, (java.lang.String.class.getClassLoader()));
        in.readList(this.result, (Result.class.getClassLoader()));
    }

    public RestResponse() {
    }

    public RestResponse(List<String> messages, List<Result> result) {
        super();
        this.messages = messages;
        this.result = result;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(messages);
        dest.writeList(result);
    }

    public int describeContents() {
        return 0;
    }

}
