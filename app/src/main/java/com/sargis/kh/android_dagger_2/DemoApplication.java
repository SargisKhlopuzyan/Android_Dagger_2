package com.sargis.kh.android_dagger_2;

import android.app.Application;
import android.content.Context;

import com.sargis.kh.android_dagger_2.data.DataManager;
import com.sargis.kh.android_dagger_2.di.component.ApplicationComponent;
import com.sargis.kh.android_dagger_2.di.component.DaggerApplicationComponent;
import com.sargis.kh.android_dagger_2.di.module.ApplicationModule;

import javax.inject.Inject;

public class DemoApplication extends Application {

    protected ApplicationComponent applicationComponent;

    @Inject
    DataManager dataManager;

    public static DemoApplication get(Context context) {
        return (DemoApplication)context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }
}
