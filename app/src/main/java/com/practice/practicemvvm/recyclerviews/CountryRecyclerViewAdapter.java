package com.practice.practicemvvm.recyclerviews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.practice.practicemvvm.R;
import com.practice.practicemvvm.model.Result;

import java.util.ArrayList;
import java.util.List;

public class CountryRecyclerViewAdapter extends RecyclerView.Adapter {

    private List<Result> resultList;

    public CountryRecyclerViewAdapter(){

        this.resultList = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.country_list_item_layout, parent, false);
        return new CountryRecyclerViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((CountryRecyclerViewViewHolder) holder).bindView(this.resultList.get(position));
    }
    public void setResultList(List<Result> list){
        if(list != null){
            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new CountryListDiffUtilsCallBack(this.resultList, list));
            this.resultList.clear();
            this.resultList.addAll(list);
            diffResult.dispatchUpdatesTo(this);

        }else{
            this.resultList.clear();
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return this.resultList.size();
    }
}
