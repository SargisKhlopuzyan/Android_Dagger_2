package com.sargis.kh.android_dagger_2.data;

import android.content.Context;
import android.content.res.Resources;

import com.sargis.kh.android_dagger_2.data.model.User;
import com.sargis.kh.android_dagger_2.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DataManager {

    private Context context;
    private DbHelper dbHelper;
    private SharedPrefsHelper sharedPrefsHelper;

    @Inject
    public DataManager(@ApplicationContext Context context,
                       DbHelper dbHelper,
                       SharedPrefsHelper sharedPrefsHelper) {

        this.context = context;
        this.dbHelper = dbHelper;
        this.sharedPrefsHelper = sharedPrefsHelper;
    }

    public void saveAccessToken(String accessToken) {
        sharedPrefsHelper.put(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, accessToken);
    }

    public String getAccessToken(){
        return sharedPrefsHelper.get(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, null);
    }

    public Long createUser(User user) throws Exception {
        return dbHelper.insertUser(user);
    }

    public User getUser(Long userId) throws Resources.NotFoundException, NullPointerException {
        return dbHelper.getUser(userId);
    }

}
