package tj.exercise.simplemvp.base.p;

import javax.inject.Inject;

/**
 * Created by tangjie on 28,八月,2017
 */

public class AbsPresenter<V, VW> implements Presenter<V, VW> {

	public V view;

	@Inject
	protected VW viewWrapper;

	@Override
	public void attachView(V mvpView) {
		this.view = mvpView;
	}

	@Override
	public void setViewWrapper(VW viewWrapper) {
		this.viewWrapper = viewWrapper;
	}

	@Override
	public void detachView() {
		this.view = null;
		viewWrapper = null;
	}
}
