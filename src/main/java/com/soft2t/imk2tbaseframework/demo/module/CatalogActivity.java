package com.soft2t.imk2tbaseframework.demo.module;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnItemClick;
import com.soft2t.imk2tbaseframework.base.BaseApplication;
import com.soft2t.imk2tbaseframework.demo.R;
import com.soft2t.imk2tbaseframework.demo.base.MyBaseActivity;
import com.soft2t.imk2tbaseframework.demo.module.demo.DemoHolderActivity;
import com.soft2t.imk2tbaseframework.demo.module.demo.DemoMakeCallActivity;
import com.soft2t.imk2tbaseframework.demo.module.demo.DemoParcelableActivity;
import com.soft2t.imk2tbaseframework.demo.module.demo.DemoRootActivity;
import com.soft2t.imk2tbaseframework.demo.module.demo.DemoShowImageActivity;
import com.soft2t.imk2tbaseframework.demo.module.demo.adapter.DemoAdapterActivity;
import com.soft2t.imk2tbaseframework.demo.module.demo.database.DemoDatabaseActivity;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_catalog)
public class CatalogActivity extends MyBaseActivity {

    @ViewInject(R.id.activity_lv)
    private ListView activity_lv;

    private ArrayAdapter<ActivityNameInfo> adapter;

    private List<ActivityNameInfo> activityNameInfoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        add(DemoAdapterActivity.class);
        add(DemoHolderActivity.class);
        add(DemoMakeCallActivity.class);
        add(DemoRootActivity.class);
        add(DemoDatabaseActivity.class);
        add(DemoShowImageActivity.class);
        add(DemoParcelableActivity.class);

        adapter = new ArrayAdapter<ActivityNameInfo>(this, R.layout.activity_demo_lv_item, R.id.name_tv, activityNameInfoList);
        activity_lv.setAdapter(adapter);
    }

    private void add(Class<? extends MyBaseActivity> clazz) {
        activityNameInfoList.add(new ActivityNameInfo(clazz));
    }

    @OnItemClick(R.id.activity_lv)
    private void intentTo(AdapterView<?> parent, View view, int position, long id) {
        ActivityNameInfo activityNameInfo = adapter.getItem(position);

        startActivity(new Intent(this, activityNameInfo.clazz));
    }

    // @Override
    // public boolean onKeyDown(int keyCode, KeyEvent event) {
    // if (keyCode == KeyEvent.KEYCODE_BACK) {
    // BaseApplication.readyToExit();
    // return true;
    // }
    //
    // return super.onKeyDown(keyCode, event);
    // }

    @Override
    public void onBackPressed() {
        BaseApplication.readyToExit();
    }

    private class ActivityNameInfo {
        private ActivityNameInfo(Class<? extends MyBaseActivity> clazz) {
            this.clazz = clazz;
        }

        private Class<? extends MyBaseActivity> clazz;

        @Override
        public String toString() {
            return clazz.getSimpleName();
        }
    }
}
