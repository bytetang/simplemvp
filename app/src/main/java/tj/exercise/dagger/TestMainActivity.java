package tj.exercise.dagger;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import javax.inject.Inject;

import tj.exercise.dagger.adapter.MainListAdapter;
import tj.exercise.dagger.component.DaggerTestMainComponent;
import tj.exercise.dagger.module.TestMainModule;
import tj.exercise.dagger.p.TestMainPresenter;
import tj.exercise.dagger.v.TestMainView;
import tj.exercise.simplemvp.base.v.AbsActivity;
import tj.exercise.simplemvp.di.ActivityScoped;

/**
 * Created by tangjie on 29,八月,2017
 */

@ActivityScoped
public class TestMainActivity extends AbsActivity<TestMainPresenter> implements TestMainView {

    @Inject
    MainListAdapter adapter;

    private RecyclerView rcyTest;
    private TextView tvTest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter.loadData();
    }

    @Override
    public void bindViews() {
        tvTest = ((TextView) findViewById(R.id.tvTest));
        rcyTest = (RecyclerView) findViewById(R.id.rcyTest);
        rcyTest.setAdapter(adapter);
    }

    @Override
    public void setupDIComponent() {
        DaggerTestMainComponent.builder()
                .testMainModule(new TestMainModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void setTextContent(String text) {
        tvTest.setText(text);
    }
}
