package tj.exercise.simplemvp.base.v;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by tangjie on 28,八月,2017
 */

public interface BaseView {

	void showToast(int resId);

	void showToast(String msg);

	void showLoadingDialog(int resId);

	void showLoadingDialog(String message);

	void showLoadingDialog(int stringId, DialogInterface.OnCancelListener listener);

	void showLoadingDialog(String message, DialogInterface.OnCancelListener listener);

	void dismissLoadingDialog();

	Context getContext();

	Activity getActivity();

	boolean isDestroyed();

	void finish();
}
