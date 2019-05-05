package com.practice.practicemvvm.data.remote;

import androidx.annotation.NonNull;

import com.practice.practicemvvm.model.CountryInfo;
import com.practice.practicemvvm.model.raxi.PlacesResponse;
import com.practice.practicemvvm.model.raxi.RouteResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class GetCountryDataRepository implements GetCountryDataService {

    private GetCountryDataService getCountryDataService;

    @Inject
    public GetCountryDataRepository(@NonNull GetCountryDataService getCountryDataService){
        this.getCountryDataService = getCountryDataService;
    }

    @Override
    public Single<CountryInfo> getResults() {
        return this.getCountryDataService.getResults();
    }

    @Override
    public Single<String> getName(int userId) {
        return this.getCountryDataService.getName(userId);
    }

    @Override
    public Single<List<RouteResponse>> getDirection(String destination, String raxiApiKey, String encoded) {

        return this.getCountryDataService.getDirection(destination, raxiApiKey, encoded);
    }

    @Override
    public Single<PlacesResponse> getAddress(String placeId, String raxiApiKey) {
        return this.getCountryDataService.getAddress(placeId, raxiApiKey);
    }

    @Override
    public Single<List<PlacesResponse>> getPlaceSuggestions(String enterAddress, String raxiApiKey, String language) {
        return this.getCountryDataService.getPlaceSuggestions(enterAddress, raxiApiKey, language);
    }
}
