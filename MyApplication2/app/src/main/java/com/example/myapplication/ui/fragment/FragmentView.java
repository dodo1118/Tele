package com.example.myapplication.ui.fragment;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FragmentView extends ViewModel {

    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();

    public void setIndex(int index) {
        mIndex.setValue(index);
    }
}