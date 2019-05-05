package com.practice.practicemvvm.base;

import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

public abstract class BaseDiffUtilsCallBack<T> extends DiffUtil.Callback {

    private final List<T> oldListItems;
    private final List<T> newListItems;

    public BaseDiffUtilsCallBack(List<T> oldListItems, List<T> newListItems){

        this.oldListItems = oldListItems;
        this.newListItems = newListItems;
    }

    @Override
    public int getOldListSize() {
        return this.oldListItems.size();
    }

    @Override
    public int getNewListSize() {
        return this.newListItems.size();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {

        return this.oldListItems.get(oldItemPosition).equals(this.newListItems.get(newItemPosition));
    }
}
