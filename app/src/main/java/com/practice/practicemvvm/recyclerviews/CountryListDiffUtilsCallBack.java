package com.practice.practicemvvm.recyclerviews;

import com.practice.practicemvvm.base.BaseDiffUtilsCallBack;
import com.practice.practicemvvm.model.Result;

import java.util.List;

public class CountryListDiffUtilsCallBack extends BaseDiffUtilsCallBack<Result> {

    private final List<Result> oldListItems;
    private final List<Result> newListItems;

    public CountryListDiffUtilsCallBack(List<Result> oldListItems, List<Result> newListItems) {
        super(oldListItems, newListItems);
        this.oldListItems = oldListItems;
        this.newListItems = newListItems;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
       return this.oldListItems.get(oldItemPosition).getName().equals(this.newListItems.get(newItemPosition).getName());
    }
}
