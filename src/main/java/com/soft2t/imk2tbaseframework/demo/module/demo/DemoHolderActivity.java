package com.soft2t.imk2tbaseframework.demo.module.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.soft2t.imk2tbaseframework.base.BaseHolder;
import com.soft2t.imk2tbaseframework.demo.R;
import com.soft2t.imk2tbaseframework.demo.base.MyBaseActivity;

@ContentView(R.layout.activity_demo_holder)
public class DemoHolderActivity extends MyBaseActivity {

	public class DemoHolder extends BaseHolder {

		public DemoHolder(Activity activity) {
			super(activity);
		}

		private int counter = 0;

		@ViewInject(R.id.demo_holder_add_btn)
		public Button demo_holder_add_btn;

		@ViewInject(R.id.demo_holder_minus_btn)
		public Button demo_holder_minus_btn;

		@OnClick(R.id.demo_holder_add_btn)
		public void show(View view) {
			String addString = demo_holder_add_btn.getText().toString();

			addString += (" " + (++counter));

			demo_holder_add_btn.setText(addString);
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		DemoHolder demoHolder = new DemoHolder(this);

		demoHolder.demo_holder_minus_btn.setEnabled(false);
	}
}