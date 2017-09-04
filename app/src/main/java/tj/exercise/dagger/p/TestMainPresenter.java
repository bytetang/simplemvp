package tj.exercise.dagger.p;

import javax.inject.Inject;

import tj.exercise.dagger.v.TestMainView;
import tj.exercise.simplemvp.base.p.AbsPresenter;

/**
 * Created by tangjie on 29,八月,2017
 */

public class TestMainPresenter extends AbsPresenter<TestMainView> {

    @Inject
    public TestMainPresenter(TestMainView view) {
        super(view);
    }

    public void loadData() {
        mView.setTextContent("hello world");
    }
}
