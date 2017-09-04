package tj.exercise.simplemvp.base.v;

import android.content.Context;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

import tj.exercise.simplemvp.base.p.AbsPresenter;

/**
 * Created by tangjie on 28,八月,2017
 */

public abstract class AbsFragment<V extends AbsPresenter> extends Fragment {

    @Inject
    protected V presenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


    @Override
    public void onDetach() {
        super.onDetach();
        if (presenter != null) {
            presenter.dettachView();
        }
    }
}
