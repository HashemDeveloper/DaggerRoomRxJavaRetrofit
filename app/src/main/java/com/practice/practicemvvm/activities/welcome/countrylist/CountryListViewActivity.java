package com.practice.practicemvvm.activities.welcome.countrylist;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.practice.practicemvvm.R;
import com.practice.practicemvvm.model.CountryInfo;
import com.practice.practicemvvm.model.Result;
import com.practice.practicemvvm.recyclerviews.CountryRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;

public class CountryListViewActivity extends AppCompatActivity implements CountryListContract.View{

    @BindView(R.id.country_list_item_recycler_view_id)
    RecyclerView countryListRecyclerView;
    @BindView(R.id.country_list_progress_bar_id)
    ProgressBar progressBar;
    private CountryRecyclerViewAdapter countryRecyclerViewAdapter;
    private Unbinder unbinder;
    private View view;

    @Inject
    CountryListContract.Presenter presenter;
    private List<Result> resultList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.country_list_layout);
        this.view = findViewById(R.id.country_list_root_view_id);
        this.presenter.attachViewModel(this);
        this.unbinder = ButterKnife.bind(this);
        this.countryListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.countryRecyclerViewAdapter = new CountryRecyclerViewAdapter();
        this.countryListRecyclerView.setAdapter(this.countryRecyclerViewAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.presenter.subscribe();
        this.presenter.processCountryListData(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.presenter.unSubscribe();
        this.unbinder.unbind();
    }

    @Override
    public void showCountryList(CountryInfo countryInfo) {
        if(countryInfo != null && countryInfo.getRestResponse() != null){
            if(countryInfo.getRestResponse().getResult() != null){
                this.countryRecyclerViewAdapter.setResultList(countryInfo.getRestResponse().getResult());
            }
        }
    }

    @Override
    public void showProgressBar(Boolean aBoolean) {
        if(aBoolean){
            this.progressBar.setVisibility(View.VISIBLE);
        }else{
            this.progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showError(Boolean aBoolean) {
        if(aBoolean){
            Snackbar snackbar = Snackbar.make(this.view, "Server Error", Snackbar.LENGTH_LONG);
            snackbar.show();
        }
    }
}
