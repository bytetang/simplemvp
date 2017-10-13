package tj.exercise.dagger.component;

import dagger.Component;
import tj.exercise.dagger.TestMainActivity;
import tj.exercise.dagger.module.TestMainModule;
import tj.exercise.simplemvp.di.ActivityScoped;

/**
 * Created by tangjie on 29,八月,2017
 */

@ActivityScoped
@Component(modules = { TestMainModule.class })
public interface TestMainComponent {

	void inject(TestMainActivity activity);
}
