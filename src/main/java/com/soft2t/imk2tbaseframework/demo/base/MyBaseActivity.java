package com.soft2t.imk2tbaseframework.demo.base;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.soft2t.imk2tbaseframework.base.BaseActivity;

public class MyBaseActivity extends BaseActivity {
	@Override
	@SuppressLint({ "NewApi", "InlinedApi" })
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// if (VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP) {
		// Window window = getWindow();
		// window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
		// window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
		// window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
		// window.setStatusBarColor(Color.TRANSPARENT);
		// window.setNavigationBarColor(Color.TRANSPARENT);
		// }
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}
}
