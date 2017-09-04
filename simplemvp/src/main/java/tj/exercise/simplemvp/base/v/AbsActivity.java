package tj.exercise.simplemvp.base.v;


import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import tj.exercise.simplemvp.base.p.AbsPresenter;

/**
 * Created by tangjie on 28,八月,2017
 */
public abstract class AbsActivity<T extends AbsPresenter> extends AppCompatActivity implements BaseView {

    @Inject
    protected T presenter;

    public AbsActivity() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupDIComponent();
        if (presenter != null) {
            presenter.dettachView();
        }
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        bindViews();
    }

    /**
     * Specify activity component for this activity.
     * component is DI entry ,relate specific module android provides.
     * after setup component ,you can ues @inject to inject member.
     */
    public abstract void setupDIComponent();

    public abstract void bindViews();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.dettachView();
        }
    }

}
