package tj.exercise.simplemvp.base.p;

import tj.exercise.simplemvp.base.v.BaseView;

/**
 * Created by tangjie on 28,八月,2017
 */

public class AbsPresenter<T extends BaseView> {

    protected T mView;

    public AbsPresenter(T view) {
        attachView();
    }

    public void attachView() {

    }

    public void dettachView() {
        this.mView = null;
    }
}
