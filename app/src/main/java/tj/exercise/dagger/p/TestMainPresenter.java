package tj.exercise.dagger.p;

import javax.inject.Inject;

import tj.exercise.dagger.v.TestMainView;
import tj.exercise.dagger.v.vw.ITestMainViewWrapper;
import tj.exercise.simplemvp.base.p.AbsPresenter;

/**
 * Created by tangjie on 29,八月,2017
 */

public class TestMainPresenter extends AbsPresenter<TestMainView, ITestMainViewWrapper> {

	@Inject
	public TestMainPresenter(TestMainView view) {
		attachView(view);
	}

	public void loadData() {
		viewWrapper.setTextContent("hello world");
	}
}
