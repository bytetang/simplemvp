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
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;

import tj.exercise.simplemvp.R;
import tj.exercise.simplemvp.base.p.AbsPresenter;
import tj.exercise.simplemvp.base.v.vw.AbsViewWrapper;
import tj.exercise.simplemvp.base.vm.ToolbarModel;
import tj.exercise.simplemvp.databinding.BaseDataBinding;
import tj.exercise.simplemvp.widget.statusbar.StatusBarUtil;

/**
 * Created by tangjie on 28,八月,2017
 */
public abstract class MvpvmActivity<P extends AbsPresenter, VW extends AbsViewWrapper, D extends ViewDataBinding>
		extends AbsActivity {

	@Inject
	protected VW viewWrapper;

	@Inject
	protected P presenter;

	protected D dataBinding;
	private BaseDataBinding baseBinding;
	protected Toolbar toolbar;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setupDIComponent();
	}

	public void generateDataBinding(@LayoutRes int layoutResID) {
		activity = this;
		if (activity instanceof IBaseToolbar && ((IBaseToolbar) activity).enableBaseToolbar()) {
			baseBinding = DataBindingUtil.setContentView(this, R.layout.base);
			ToolbarModel toolbarModel = new ToolbarModel();
			toolbarModel.setShowLeftTitle(!((IBaseToolbar) activity).isBaseToolbarCenterTitle());
			baseBinding.setToolbarModel(toolbarModel);
			if (((IBaseToolbar) activity).enableBaseTabLayout()) {
				baseBinding.getToolbarModel().setShowTabLayout(true);
			} else {
				baseBinding.getToolbarModel().setShowTabLayout(false);
			}
			if (!((IBaseToolbar) activity).enableBaseToolbarNavigationIcon()) {
				baseBinding.toolbarLayout.toolbar.setNavigationIcon(null);
			}
			baseBinding.toolbarLayout.toolbar.setTitleTextColor(Color.BLACK);
			LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			dataBinding = DataBindingUtil.inflate(inflater, layoutResID, baseBinding.contentLayout, true);
			enableToolBar(baseBinding.toolbarLayout.toolbar, true, false);
		} else {
			dataBinding = DataBindingUtil.setContentView(this, layoutResID);
		}

		initPresenterAndViewWrapper();
	}

	protected void setStatusBar() {
		StatusBarUtil.setColor(this, Color.TRANSPARENT, 0);
	}

	public void enableToolBar(Toolbar toolbar, boolean backEnable, boolean titleEnable) {
		setSupportActionBar(toolbar);
		ActionBar actionBar = getSupportActionBar();
		assert actionBar != null;
		actionBar.setDisplayHomeAsUpEnabled(backEnable);
		actionBar.setDisplayShowTitleEnabled(titleEnable);
		setStatusBar();
	}

	public BaseDataBinding getBaseBinding() {
		return baseBinding;
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

	/**
	 * Specify activity component for this activity. component is DI entry ,relate
	 * specific module android provides. after setup component ,you can ues @inject
	 * to inject member.
	 */
	public abstract void setupDIComponent();

	@Override
	protected void onDestroy() {
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
		super.onDestroy();
	}

}
