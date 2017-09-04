package tj.exercise.dagger.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by tangjie on 29,八月,2017
 */

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.MainHolder> {
    private List<String> data;

    @Inject
    public MainListAdapter(List<String> data) {
        this.data = data;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public MainHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MainHolder holder, int position) {

    }

    static class MainHolder extends RecyclerView.ViewHolder {
        public MainHolder(View view) {
            super(view);
        }
    }
}
