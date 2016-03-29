package com.soft2t.imk2tbaseframework.demo.module.demo.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.lidroid.xutils.view.annotation.event.OnItemClick;
import com.soft2t.imk2tbaseframework.base.BaseApplication.MyToastManager;
import com.soft2t.imk2tbaseframework.demo.R;
import com.soft2t.imk2tbaseframework.demo.base.MyBaseActivity;
import com.soft2t.imk2tbaseframework.util.image.ImageReflect;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@ContentView(R.layout.activity_demo_adapter)
public class DemoAdapterActivity extends MyBaseActivity {

	@ViewInject(R.id.info_lv)
	private ListView info_lv;

	@ViewInject(R.id.add_more_item_btn)
	private Button add_more_item_btn;

	@ViewInject(R.id.view_to_reflect_flyt)
	private FrameLayout view_to_reflect_flyt;

	@ViewInject(R.id.img_imgv)
	private ImageView img_imgv;

	@ViewInject(R.id.info_txt)
	private TextView info_txt;

	@ViewInject(R.id.img_reflect_imgv)
	private ImageView img_reflect_imgv;

	private DemoAdapter ca;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(new ImageShadowView(this));

		fillListViewTestData();
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);

		showReflectedImage();
	}

	private void showReflectedImage() {
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
		img_imgv.setImageBitmap(bitmap);

		bitmap = ImageReflect.getViewBitmap(view_to_reflect_flyt);

		bitmap = ImageReflect.createReflectedImage(bitmap, view_to_reflect_flyt.getHeight() / 2);
		img_reflect_imgv.setImageBitmap(bitmap);

		bitmap = null;
	}

	private void fillListViewTestData() {
		List<MyData> list = new ArrayList<>();

		for (int i = 0; i < 50; i++) {
			MyData myData = new MyData();
			myData.name = String.valueOf(i + " init");
			list.add(myData);
		}

		ca = new DemoAdapter(this, list, R.layout.activity_demo_lv_item);
		info_lv.setAdapter(ca);

		// =========================================

		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				List<MyData> listTemp = new ArrayList<>();
				for (int i = 0; i < 50; i++) {
					MyData myData = new MyData();
					myData.name = String.valueOf(i);

					listTemp.add(myData);
				}

				// ca.addItem(listTemp);
				ca.setItem(listTemp);
			}
		}, 2000);
	}

	@OnClick(R.id.add_more_item_btn)
	private void add_more_item(View view) {
		MyData myData = new MyData();
		myData.name = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault()).format(new Date());

		// ArrayList<MyData> listTemp = new ArrayList<MyData>();
		// listTemp.add(myData);

		ca.addItemToFirst(myData);
	}

	@OnItemClick(R.id.info_lv)
	public void showItemName(AdapterView<?> parent, View view, int position, long id) {
		MyData myData = ca.getItem(position);

		MyToastManager.showToast(this, "行点击: " + myData.name);
	}
}