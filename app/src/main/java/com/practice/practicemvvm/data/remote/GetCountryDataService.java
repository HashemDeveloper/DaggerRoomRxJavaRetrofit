package com.practice.practicemvvm.data.remote;

import com.practice.practicemvvm.model.CountryInfo;
import com.practice.practicemvvm.model.raxi.PlacesResponse;
import com.practice.practicemvvm.model.raxi.RouteResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetCountryDataService {

    @GET("country/get/all")
    Single<CountryInfo> getResults();

    Single<String> getName(int userId);

    @GET("geo/directions?")
    Single<List<RouteResponse>> getDirection(@Query("waypoints")String destination, @Query("key") String raxiApiKey, @Query("encoded")String encoded);

    @GET("geo/places/{PLACE_ID}")
    Single<PlacesResponse> getAddress(@Path("PLACE_ID") String placeId, @Query("key") String raxiApiKey);

    @GET("geo/places?")
    Single<List<PlacesResponse>> getPlaceSuggestions(@Query("query") String enterAddress, @Query("key") String raxiApiKey, @Query("language") String language);
}
