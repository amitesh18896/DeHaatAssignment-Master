package com.dehaat.dehaatassignment.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import com.dehaat.dehaatassignment.manager.SessionManager;
import com.dehaat.dehaatassignment.repository.AuthorRepo;

/**
 * Created by Pallaw Pathak on 16/06/20. - https://www.linkedin.com/in/pallaw-pathak-a6a324a1/
 */
public class MainViewModel extends AndroidViewModel {
    private Application application;
    private AuthorRepo authorRepo;

    public MainViewModel(Application application, AuthorRepo authorRepo) {
        super(application);
        this.application = application;
        this.authorRepo = authorRepo;
    }

    public boolean isSessionExpired() {
        return SessionManager.getInstance().isSessionExpired();
    }
}
