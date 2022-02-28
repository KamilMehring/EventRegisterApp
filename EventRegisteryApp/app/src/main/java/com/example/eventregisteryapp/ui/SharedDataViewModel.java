package com.example.eventregisteryapp.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedDataViewModel extends ViewModel {
    private final MutableLiveData<String> sd = new MutableLiveData<>();

    public void setData(String data) {
        sd.setValue(data);
    }

    public String getData() {
        return sd.getValue();
    }

}
