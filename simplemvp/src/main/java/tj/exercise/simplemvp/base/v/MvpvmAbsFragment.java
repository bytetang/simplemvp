package tj.exercise.simplemvp.base.v;

import javax.inject.Inject;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tj.exercise.simplemvp.R;
import tj.exercise.simplemvp.base.p.AbsPresenter;
import tj.exercise.simplemvp.base.v.vw.AbsViewWrapper;
import tj.exercise.simplemvp.base.vm.ToolbarModel;
import tj.exercise.simplemvp.databinding.BaseDataBinding;

/**
 * Created by tangjie on 28,八月,2017
 */

public abstract class MvpvmAbsFragment<P extends AbsPresenter, VW extends AbsViewWrapper, D extends ViewDataBinding>
		extends AbsFragment {

	protected D dataBinding;

	@Inject
	protected P presenter;

	@Inject
	protected VW viewWrapper;

	private BaseDataBinding baseBinding;

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setupDIComponent();
	}

	protected void generateDataBinding(LayoutInflater inflater, ViewGroup container, @LayoutRes int layoutResID) {
		fragment = this;
		if (fragment instanceof IBaseToolbar && ((IBaseToolbar) fragment).enableBaseToolbar()) {
			baseBinding = DataBindingUtil.inflate(inflater, R.layout.base, container, false);
			ToolbarModel toolbarModel = new ToolbarModel();
			toolbarModel.setShowLeftTitle(!((IBaseToolbar) fragment).isBaseToolbarCenterTitle());
			baseBinding.setToolbarModel(toolbarModel);
			if (((IBaseToolbar) fragment).enableBaseTabLayout()) {
				baseBinding.getToolbarModel().setShowTabLayout(true);
			} else {
				baseBinding.getToolbarModel().setShowTabLayout(false);
			}
			if (!((IBaseToolbar) fragment).enableBaseToolbarNavigationIcon()) {
				baseBinding.toolbarLayout.toolbar.setNavigationIcon(null);
			}
			baseBinding.toolbarLayout.toolbar.setTitleTextColor(Color.BLACK);
			dataBinding = DataBindingUtil.inflate(inflater, layoutResID, baseBinding.contentLayout, true);
			enableToolBar(baseBinding.toolbarLayout.toolbar, true, false);
		} else {
			dataBinding = DataBindingUtil.inflate(inflater, layoutResID, container, false);
		}

		initPresenterAndViewWrapper();
	}

	protected void initPresenterAndViewWrapper() {
		if (viewWrapper != null) {
			if (presenter != null) {
				presenter.setViewWrapper(viewWrapper);
			}
			if (dataBinding != null) {
				viewWrapper.setBinding(dataBinding);
			}
		}
	}

	public void enableToolBar(Toolbar toolbar, boolean backEnable, boolean titleEnable) {
		((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
		ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
		assert actionBar != null;
		actionBar.setDisplayHomeAsUpEnabled(backEnable);
		actionBar.setDisplayShowTitleEnabled(titleEnable);
		setTitle(activity.getTitle() != null ? activity.getTitle().toString() : null);
	}

	public BaseDataBinding getBaseBinding() {
		return baseBinding;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		setUserVisibleHint(getUserVisibleHint());
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		activity = (AbsActivity) getActivity();
	}

	@Override
	public final void setUserVisibleHint(boolean isVisibleToUser) {
		super.setUserVisibleHint(isVisibleToUser);
		if (getView() != null) {
			setVisibleHint(isVisibleToUser);
		}
	}

	protected void setVisibleHint(boolean isVisibleToUser) {

	}

	@Override
	public void onDestroyView() {
		activity = null;
		fragment = null;
		super.onDestroyView();
	}

	/**
	 * Specify activity component for this activity. component is DI entry ,relate
	 * specific module android provides. after setup component ,you can ues @inject
	 * to inject member.
	 */
	public abstract void setupDIComponent();

	@Override
	public void onDetach() {
		if (presenter != null) {
			presenter.detachView();
		}
		if (viewWrapper != null) {
			viewWrapper.detachView();
		}
		if (dataBinding != null) {
			dataBinding.unbind();
			dataBinding = null;
		}
		if (baseBinding != null) {
			baseBinding.unbind();
			baseBinding = null;
		}
		super.onDetach();
	}

	@Override
	public void setTitle(CharSequence title) {
		if (activity != null && activity instanceof IBaseToolbar && ((IBaseToolbar) activity).enableBaseToolbar()) {
			if (((IBaseToolbar) activity).isBaseToolbarCenterTitle()) {
				getBaseBinding().toolbarLayout.tvCenterTitle.setText(title);
			} else {
				getBaseBinding().toolbarLayout.tvLeftTitle.setText(title);
			}
		} else {
			activity.setTitle(title);
		}
	}

	@Override
	public void setTitle(int titleId) {
		setTitle(getString(titleId));
	}
}
