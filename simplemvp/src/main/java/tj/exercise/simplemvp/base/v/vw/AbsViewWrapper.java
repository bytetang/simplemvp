package tj.exercise.simplemvp.base.v.vw;

import android.databinding.ViewDataBinding;

/**
 * Description: <> Author: qiyangzhao Date: 12/10/2017 Copyright: Ctrip
 */

public abstract class AbsViewWrapper<V, D extends ViewDataBinding> implements ViewWrapper<V, D> {

	protected V view;
	protected D dataBinding;

	@Override
	public void attachView(V view) {
		this.view = view;
	}

	@Override
	public void setBinding(D dataBinding) {
		this.dataBinding = dataBinding;
		onBind();
	}

	@Override
	public void detachView() {
		view = null;
		dataBinding = null;
	}
}
