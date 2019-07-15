package com.sargis.kh.android_dagger_2.di.component;

import com.sargis.kh.android_dagger_2.MainActivity;
import com.sargis.kh.android_dagger_2.di.PerActivity;
import com.sargis.kh.android_dagger_2.di.module.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
