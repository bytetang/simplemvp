package tj.exercise.simplemvp.base.v;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Description: <> Author: qiyangzhao Date: 12/10/2017 Copyright: Ctrip
 */

public abstract class AbsActivity extends AppCompatActivity implements IBaseView {

	protected AbsActivity activity;
	private boolean destroyed = false;
	private Dialog loadingDialog;

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			try {
				super.onBackPressed();
				return true;
			} catch (Throwable t) {
			}
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onDestroy() {
		destroyed = true;
		activity = null;
		super.onDestroy();
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
	}

	@Override
	public void onTrimMemory(int level) {
		super.onTrimMemory(level);
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

	private boolean createLoadingDialog(String message) {
		// TODO create dialog
		return true;
	}

	@Override
	public void showLoadingDialog(int resId) {
		showLoadingDialog(getString(resId));
	}

	@Override
	public void showLoadingDialog(String message) {
		if (createLoadingDialog(message)) {
			loadingDialog.setCancelable(false);
			loadingDialog.show();
		}
	}

	@Override
	public void showLoadingDialog(int stringId, DialogInterface.OnCancelListener listener) {
		showLoadingDialog(getString(stringId), listener);
	}

	@Override
	public void showLoadingDialog(String message, DialogInterface.OnCancelListener listener) {
		if (createLoadingDialog(message)) {
			loadingDialog.setCanceledOnTouchOutside(false);
			loadingDialog.setCancelable(true);
			loadingDialog.setOnCancelListener(listener);
			loadingDialog.show();
		}
	}

	@Override
	public void dismissLoadingDialog() {
		if (!isDestroyed() && loadingDialog != null && loadingDialog.isShowing())
			loadingDialog.dismiss();
	}

	@Override
	public Context getContext() {
		return this;
	}

	@Override
	public Activity getActivity() {
		return this;
	}

	@Override
	public boolean isDestroyed() {
		return destroyed;
	}
}
