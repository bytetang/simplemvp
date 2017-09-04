package tj.exercise.dagger;

import android.app.Application;

import tj.exercise.simplemvp.di.ApplicationModule;
import tj.exercise.simplemvp.di.DaggerApplicationComponent;

/**
 * Created by tangjie on 29,八月,2017
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build().inject(this);
    }
}
