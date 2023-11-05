package com.example.counterapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.counterapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    MyViewModel viewModel;
ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);

       viewModel = new ViewModelProvider(this).get(MyViewModel.class);

       //Link the Data with ViewHolder
        mainBinding.setMyViewModel(viewModel);

    //Observing the LiveData
        viewModel.getCounter().observe(this,
                new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer count) {
                        mainBinding.counter.setText(""+count);
                    }
                }
        );
    }
}