package com.dehaat.dehaatassignment.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.dehaat.dehaatassignment.R;
import com.dehaat.dehaatassignment.repository.AuthorRepo;
import com.dehaat.dehaatassignment.viewmodel.MainViewModel;
import com.dehaat.dehaatassignment.viewmodel.ViewModelFactory;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init view model
        initViewModel();

        checkLoginSession();
    }

    private void checkLoginSession() {
        if (mainViewModel.isSessionExpired()) {
            Intent toLogin = new Intent(this, LoginActivity.class);
            toLogin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(toLogin);
        }
    }

    private void initViewModel() {
        ViewModelFactory factory = new ViewModelFactory(getApplication(), getRepo());
        mainViewModel = ViewModelProviders.of(this, factory).get(MainViewModel.class);
    }

    private AuthorRepo getRepo() {
        return null;
    }
}
