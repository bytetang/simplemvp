package tj.exercise.simplemvp.base.m;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by tangjie on 29,八月,2017
 */

public class AbsModel {

    @Inject
    public AbsModel() {

    }

    public void send() {
        Log.d("AbsModel", "send");
    }
}
