package com.dehaat.dehaatassignment;

import android.app.Application;

import com.dehaat.dehaatassignment.manager.SessionManager;
import com.dehaat.dehaatassignment.rest.AppRestClient;

/**
 * Created by Pallaw Pathak on 15/06/20. - https://www.linkedin.com/in/pallaw-pathak-a6a324a1/
 */
public class App extends Application {
    private static App mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        setInstance(this);

        //initialize retrofit client
        AppRestClient.init(this);

        //initialize session manager
        SessionManager.init(this);
    }

    private static synchronized void setInstance(App app) {
        mInstance = app;
    }

    public static App getAppContext() {
        return mInstance;
    }
}
