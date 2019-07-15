package com.sargis.kh.android_dagger_2.di.component;

import android.app.Application;
import android.content.Context;

import com.sargis.kh.android_dagger_2.DemoApplication;
import com.sargis.kh.android_dagger_2.data.DataManager;
import com.sargis.kh.android_dagger_2.data.DbHelper;
import com.sargis.kh.android_dagger_2.data.SharedPrefsHelper;
import com.sargis.kh.android_dagger_2.di.ApplicationContext;
import com.sargis.kh.android_dagger_2.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(DemoApplication demoApplication);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();

    DbHelper getDbHelper();

}
