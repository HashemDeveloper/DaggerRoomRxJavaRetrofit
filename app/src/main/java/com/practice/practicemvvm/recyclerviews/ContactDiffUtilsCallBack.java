package com.practice.practicemvvm.recyclerviews;

import com.practice.practicemvvm.base.BaseDiffUtilsCallBack;
import com.practice.practicemvvm.data.room.entities.Contacts;

import java.util.List;

public class ContactDiffUtilsCallBack extends BaseDiffUtilsCallBack<Contacts> {

    private final List<Contacts> oldListItems;
    private final List<Contacts> newListItems;

    ContactDiffUtilsCallBack(List<Contacts> oldListItems, List<Contacts> newListItems) {
        super(oldListItems, newListItems);

        this.oldListItems = oldListItems;
        this.newListItems = newListItems;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return this.oldListItems.get(oldItemPosition).getId().equals(this.newListItems.get(newItemPosition).getId());
    }
}
