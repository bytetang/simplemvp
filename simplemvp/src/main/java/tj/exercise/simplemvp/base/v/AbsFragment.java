package tj.exercise.simplemvp.base.v;

import android.app.Fragment;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Description: <> Author: qiyangzhao Date: 12/10/2017 Copyright: Ctrip
 */

public abstract class AbsFragment extends Fragment implements IBaseView {

	protected AbsActivity activity;
	AbsFragment fragment;
	private boolean destroyed = false;

	@Override
	public void onDestroy() {
		destroyed = true;
		super.onDestroy();
	}

	@Override
	public void showToast(int resId) {
		showToast(getString(resId));
	}

	@Override
	public void showToast(String msg) {
		if (!TextUtils.isEmpty(msg)) {
			Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void showLoadingDialog(int resId) {
		if (activity != null) {
			activity.showLoadingDialog(resId);
		}
	}

	@Override
	public void showLoadingDialog(String message) {
		if (activity != null) {
			activity.showLoadingDialog(message);
		}
	}

	@Override
	public void showLoadingDialog(int stringId, DialogInterface.OnCancelListener listener) {
		if (activity != null) {
			activity.showLoadingDialog(stringId, listener);
		}
	}

	@Override
	public void showLoadingDialog(String message, DialogInterface.OnCancelListener listener) {
		if (activity != null) {
			activity.showLoadingDialog(message, listener);
		}
	}

	@Override
	public void dismissLoadingDialog() {
		if (activity != null) {
			activity.dismissLoadingDialog();
		}
	}

	@Override
	public void finish() {
		if (activity != null) {
			activity.finish();
		}
	}

	@Override
	public boolean isDestroyed() {
		return destroyed;
	}
}
