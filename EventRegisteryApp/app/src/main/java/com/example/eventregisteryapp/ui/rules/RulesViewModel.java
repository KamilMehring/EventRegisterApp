package com.example.eventregisteryapp.ui.rules;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RulesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RulesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Regulamin");
    }

    public LiveData<String> getText() {
        return mText;
    }
}