package com.dehaat.dehaatassignment.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.dehaat.dehaatassignment.repository.AuthorRepo;

/**
 * Created by Pallaw Pathak on 16/06/20. - https://www.linkedin.com/in/pallaw-pathak-a6a324a1/
 */
public class ViewModelFactory implements ViewModelProvider.Factory {

    private Application application;
    private AuthorRepo authorRepo;

    public ViewModelFactory(Application application, AuthorRepo authorRepo) {
        this.application = application;
        this.authorRepo = authorRepo;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        try {
            return modelClass.getConstructor(Application.class, AuthorRepo.class).newInstance(application, authorRepo);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Can not create instance of " + e);
        }
    }
}
