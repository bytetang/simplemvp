package tj.exercise.dagger.v.vw;

import javax.inject.Inject;

import tj.exercise.dagger.adapter.MainListAdapter;
import tj.exercise.dagger.databinding.TestMainDataBinding;
import tj.exercise.dagger.v.TestMainView;
import tj.exercise.simplemvp.base.v.vw.AbsViewWrapper;

/**
 * Description: <> Author: qiyangzhao Date: 12/10/2017 Copyright: Ctrip
 */

public class TestMainViewWrapper extends AbsViewWrapper<TestMainView, TestMainDataBinding>
		implements ITestMainViewWrapper {

	@Inject
	MainListAdapter adapter;

	public TestMainViewWrapper(TestMainView view) {
		attachView(view);
	}

	@Override
	public void onBind() {
		dataBinding.rcyTest.setAdapter(adapter);
	}

	@Override
	public void setTextContent(String text) {
		dataBinding.tvTest.setText(text);
	}
}
