package com.dehaat.dehaatassignment.manager;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Pallaw Pathak on 16/06/20. - https://www.linkedin.com/in/pallaw-pathak-a6a324a1/
 */
public class SessionManager {
    private static final SessionManager ourInstance = new SessionManager();
    private static final String KEY_TOKEN = "token";
    private static SharedPreferences pref;
    private static SharedPreferences.Editor editor;

    public synchronized static SessionManager getInstance() {
        return ourInstance;
    }

    public static void init(Context context) {
        pref = context.getSharedPreferences("dehaat_pref", Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    private SessionManager() {
    }

    public boolean isSessionExpired() {
        return pref.getString(KEY_TOKEN, "").isEmpty();
    }
}
