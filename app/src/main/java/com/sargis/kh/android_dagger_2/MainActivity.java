package com.sargis.kh.android_dagger_2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.sargis.kh.android_dagger_2.data.DataManager;
import com.sargis.kh.android_dagger_2.data.model.User;
import com.sargis.kh.android_dagger_2.di.component.ActivityComponent;
import com.sargis.kh.android_dagger_2.di.component.DaggerActivityComponent;
import com.sargis.kh.android_dagger_2.di.module.ActivityModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    DataManager dataManager;

    private ActivityComponent activityComponent;

    private TextView textViewUserInfo;
    private TextView textViewAccessToken;

    public ActivityComponent getActivityComponent() {

        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(DemoApplication.get(this).getComponent())
                    .build();
        }

        return activityComponent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        textViewUserInfo = findViewById(R.id.textViewUserInfo);
        textViewAccessToken = findViewById(R.id.textViewAccessToken);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        createUser();
        getUser();
        dataManager.saveAccessToken("ASDR12443JFDJF43543J543H3K543");

        String token = dataManager.getAccessToken();
        if (token != null) {
            textViewAccessToken.setText(token);
        }
    }

    private void createUser() {
        try {
            dataManager.createUser(new User("Ali", "1367, Gurgaon, Haryana, India"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getUser() {
        try {
            User user = dataManager.getUser(1L);
            textViewUserInfo.setText(user.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
