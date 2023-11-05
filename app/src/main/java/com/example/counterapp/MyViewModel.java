package com.example.counterapp;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private MutableLiveData<Integer> counter = new MutableLiveData<>();

    public void increaseCounter(View view){
        //retrieves the current value from LiveData
        int currentValue = counter.getValue() !=null ? counter.getValue():0;

        //Increase value by one
        counter.postValue(currentValue+1);
    }

    public LiveData<Integer> getCounter() {
        return counter;
    }
}
