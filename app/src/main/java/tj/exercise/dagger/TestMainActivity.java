package tj.exercise.dagger;

import android.os.Bundle;
import android.support.annotation.Nullable;

import tj.exercise.dagger.component.DaggerTestMainComponent;
import tj.exercise.dagger.databinding.TestMainDataBinding;
import tj.exercise.dagger.module.TestMainModule;
import tj.exercise.dagger.p.TestMainPresenter;
import tj.exercise.dagger.v.TestMainView;
import tj.exercise.dagger.v.vw.TestMainViewWrapper;
import tj.exercise.simplemvp.base.v.IBaseToolbar;
import tj.exercise.simplemvp.base.v.MvpvmAbsActivity;
import tj.exercise.simplemvp.di.ActivityScoped;

/**
 * Created by tangjie on 29,八月,2017
 */

@ActivityScoped
public class TestMainActivity extends MvpvmAbsActivity<TestMainPresenter, TestMainViewWrapper, TestMainDataBinding>
		implements TestMainView, IBaseToolbar {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		generateDataBinding(R.layout.activity_main);
		presenter.loadData();
	}

	@Override
	public void setupDIComponent() {
		DaggerTestMainComponent.builder().testMainModule(new TestMainModule(this)).build().inject(this);
	}

	@Override
	public void setTextContent(String text) {

	}

	@Override
	public boolean enableBaseToolbar() {
		return true;
	}

	@Override
	public boolean enableBaseTabLayout() {
		return false;
	}

	@Override
	public boolean isBaseToolbarCenterTitle() {
		return true;
	}

	@Override
	public boolean enableBaseToolbarNavigationIcon() {
		return false;
	}
}
