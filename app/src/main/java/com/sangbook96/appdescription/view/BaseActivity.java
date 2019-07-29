package com.sangbook96.appdescription.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.sangbook96.appdescription.R;

import java.util.Objects;

public class BaseActivity extends Activity {
    private static final String TAG = BaseActivity.class.getSimpleName();

    Dialog mDialogLoading;

    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDialogLoading = new Dialog(this);
        mDialogLoading.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        mDialogLoading.setCancelable(false);
        mDialogLoading.setContentView(R.layout.layout_progress);
        Objects.requireNonNull(mDialogLoading.getWindow()).clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        mDialogLoading.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        mProgressBar = mDialogLoading.findViewById(R.id.progress_bar_layout);
    }

    /**
     * Turn off keyboard when click outside area
     *
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View view = getCurrentFocus();
        if (view != null && (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) && view instanceof EditText && !view.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            view.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + view.getLeft() - scrcoords[0];
            float y = ev.getRawY() + view.getTop() - scrcoords[1];
            if (x < view.getLeft() || x > view.getRight() || y < view.getTop() || y > view.getBottom())
                ((InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow((this.getWindow().getDecorView().getApplicationWindowToken()), 0);
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * Show dialog loadingTAG
     */
    public void showLoading() {
        if (!mDialogLoading.isShowing()) {
            mProgressBar.setVisibility(View.VISIBLE);
            mDialogLoading.show();
        }
    }

    /**
     * Hide dialog loading
     */
    public void hideLoading() {
        if (mDialogLoading.isShowing()) {
            mProgressBar.setVisibility(View.GONE);
            mDialogLoading.dismiss();
        }
    }

    public void showDialogErrorMsg(String message) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(BaseActivity.this);
        dialog.setTitle(getString(R.string.error));
        dialog.setMessage(message.replace("\\n", "\n"));
        dialog.setCancelable(false);
        dialog.setNegativeButton(getString(R.string.yes), null);
        dialog.show();
    }

    public void showDialogErrorNetwork() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(BaseActivity.this);
        dialog.setTitle(getString(R.string.error));
        dialog.setMessage(getString(R.string.error_network));
        dialog.setCancelable(false);
        dialog.setNegativeButton(getString(R.string.yes), null);
        dialog.show();
    }

}
