package tj.exercise.simplemvp.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tangjie on 29,八月,2017
 */

@Singleton
@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplicationContext() {
        return this.application;
    }

}
