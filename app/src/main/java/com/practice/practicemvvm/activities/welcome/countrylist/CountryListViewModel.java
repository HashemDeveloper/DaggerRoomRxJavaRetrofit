package com.practice.practicemvvm.activities.welcome.countrylist;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.practice.practicemvvm.data.remote.GetCountryDataRepository;
import com.practice.practicemvvm.model.CountryInfo;
import com.practice.practicemvvm.model.raxi.PlacesResponse;
import com.practice.practicemvvm.model.raxi.RouteResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class CountryListViewModel extends ViewModel {

    @NonNull
    private GetCountryDataRepository getCountryDataRepository;
    @NonNull
    private CompositeDisposable compositeDisposable;
    private MutableLiveData<CountryInfo> countryInfoMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private MutableLiveData<Boolean> isError = new MutableLiveData<>();

    @Inject
    public CountryListViewModel(@NonNull GetCountryDataRepository getCountryDataRepository){
        this.getCountryDataRepository = getCountryDataRepository;
        this.compositeDisposable = new CompositeDisposable();
        fetchData();
//        fetchDirection();
//        fetchPlace();
//        fetchPlaceSuggestions();
    }

    public LiveData<CountryInfo> getCountryInfoMutableLiveData(){
        return this.countryInfoMutableLiveData;
    }
    public LiveData<Boolean> getIsLoading(){
        return this.isLoading;
    }
    public LiveData<Boolean> getIsError(){
        return this.isError;
    }

    private void fetchDirection(){
        String destination = "40.7128,-74.0060|40.7829,-73.9654";
        this.compositeDisposable.add(this.getCountryDataRepository.getDirection(destination, "dade4c02-d0fd-4e02-a3d1-23b362c2c5b7", "yes")
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableSingleObserver<List<RouteResponse>>() {
            @Override
            public void onSuccess(List<RouteResponse> routeResponses) {
                for(int i = 0; i < routeResponses.size(); i++){
                    RouteResponse routeResponse = routeResponses.get(i);
                    Log.i("Source: ", routeResponse.getSource());
                    Log.i("Routs:", routeResponse.getRoutes().get(0).getPointsEncoded());

                }
            }

            @Override
            public void onError(Throwable e) {
                Log.i("Error: ", e.getMessage());
            }
        }));
    }

    private void fetchPlaceSuggestions(){

        String address = "94 Troy Ave Brooklyn NY";
        String raxiApiKey = "dade4c02-d0fd-4e02-a3d1-23b362c2c5b7";

        this.compositeDisposable.add(this.getCountryDataRepository.getPlaceSuggestions(address, raxiApiKey, "en")
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableSingleObserver<List<PlacesResponse>>() {
            @Override
            public void onSuccess(List<PlacesResponse> placesResponses) {
                for(PlacesResponse response : placesResponses){
                    Log.i("Response: ", response.getAddressString());
                }
            }

            @Override
            public void onError(Throwable e) {
                //java.net.SocketTimeoutException: timeout
                //Service Unavailable: Back-end server is at capacity
                //HTTP 503 Service Unavailable: Back-end server is at capacity
                Log.i("Error: ", e.getMessage());
            }
        }));
    }

    private void fetchPlace(){
        String placeId = "ChIJd8QtfIdbwokR04nABWznPUk";
        String raxiApiKey = "dade4c02-d0fd-4e02-a3d1-23b362c2c5b7";
        this.compositeDisposable.add(this.getCountryDataRepository.getAddress(placeId, raxiApiKey)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableSingleObserver<PlacesResponse>() {
            @Override
            public void onSuccess(PlacesResponse placesResponse) {
                Log.e("Address: ", placesResponse.getAddressString());
            }

            @Override
            public void onError(Throwable e) {
                Log.i("Error: ", e.getMessage());
            }
        }));
    }

    private void fetchData(){

        this.isLoading.setValue(true);
        this.compositeDisposable.add(this.getCountryDataRepository.getResults()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableSingleObserver<CountryInfo>() {
            @Override
            public void onSuccess(CountryInfo countryInfo) {
                isLoading.setValue(false);
                isError.setValue(false);
                Log.i("CountryInfo: ", countryInfo.toString());
                countryInfoMutableLiveData.setValue(countryInfo);
            }

            @Override
            public void onError(Throwable e) {
                Log.i("Error: ", e.getMessage());
                isLoading.setValue(false);
                isError.setValue(true);
            }
        }));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.clear();
    }
}
