package com.sargis.kh.android_dagger_2.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.sargis.kh.android_dagger_2.di.ApplicationContext;
import com.sargis.kh.android_dagger_2.di.DatabaseInfo;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return "demo-dagger.db";
    }

    @Provides
    @DatabaseInfo
    Integer provideDatabaseVersion() {
        return 1;
    }

    @Provides
    SharedPreferences provideSharedPrefs() {
        return application.getSharedPreferences("demo-prefs", Context.MODE_PRIVATE);
    }

}
