package com.practice.practicemvvm.recyclerviews;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.practice.practicemvvm.R;
import com.practice.practicemvvm.model.Result;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountryRecyclerViewViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.country_list_item_country_name_view_id)
    AppCompatTextView countryNameView;

    public CountryRecyclerViewViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    void bindView(Result result){

        if(result != null && result.getName() != null){
            this.countryNameView.setText(result.getName());
        }
    }
}
