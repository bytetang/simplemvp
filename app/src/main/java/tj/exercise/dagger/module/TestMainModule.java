package tj.exercise.dagger.module;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;
import tj.exercise.dagger.adapter.MainListAdapter;
import tj.exercise.dagger.p.TestMainPresenter;
import tj.exercise.dagger.v.TestMainView;
import tj.exercise.dagger.v.vw.TestMainViewWrapper;
import tj.exercise.simplemvp.di.ActivityScoped;

/**
 * Created by tangjie on 29,八月,2017
 */

@Module
public class TestMainModule {

	private TestMainView mView;

	public TestMainModule(TestMainView view) {
		this.mView = view;
	}

	@Provides
	@ActivityScoped
	TestMainView providesMainView() {
		return mView;
	}

	@Provides
	@ActivityScoped
	TestMainPresenter providePresenter() {
		return new TestMainPresenter(mView);
	}

	@Provides
	@ActivityScoped
	TestMainViewWrapper provideViewWrapper() {
		return new TestMainViewWrapper(mView);
	}

	@Provides
	@ActivityScoped
	MainListAdapter provideListAdapter(List<String> data) {
		return new MainListAdapter(data);
	}

	@Provides
	@ActivityScoped
	List<String> provideListData() {
		List<String> data = new ArrayList<>();
		return data;
	}
}
