package tj.exercise.simplemvp.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by tangjie on 29,八月,2017
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Application context();

    void inject(Application application);
}
