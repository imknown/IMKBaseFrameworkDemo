package com.soft2t.imk2tbaseframework.demo.module.demo.database;

import java.util.List;

import com.soft2t.imk2tbaseframework.base.BaseApplication.MyToastManager;
import com.soft2t.imk2tbaseframework.demo.base.MyBaseActivity;

import android.os.Bundle;

public class DemoDatabaseActivity extends MyBaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		List<DiseaseSelfCheckPartEntity> diseaseSelfCheckPartEntityList = new DiseaseSelfCheckDao().getPartEntityList();

		MyToastManager.showToast(this, "" + diseaseSelfCheckPartEntityList.size());

		// ViewPagerIndicator vpi = new ViewPagerIndicator(this);
		// ViewPager vp = new ViewPager(this);
		// vpi.setVp(vp);
		//
		// setContentView(vpi);
	}
}
