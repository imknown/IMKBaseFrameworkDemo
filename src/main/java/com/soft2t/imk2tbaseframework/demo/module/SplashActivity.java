package com.soft2t.imk2tbaseframework.demo.module;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;

import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.view.annotation.ContentView;
import com.soft2t.imk2tbaseframework.base.BaseApplication;
import com.soft2t.imk2tbaseframework.base.BaseApplication.MyToastManager;
import com.soft2t.imk2tbaseframework.base.BaseRequestCallBack;
import com.soft2t.imk2tbaseframework.base.BaseWebUrl;
import com.soft2t.imk2tbaseframework.base.Constant;
import com.soft2t.imk2tbaseframework.base.update.DbUpgradeHelper;
import com.soft2t.imk2tbaseframework.base.update.UpdateService;
import com.soft2t.imk2tbaseframework.demo.R;
import com.soft2t.imk2tbaseframework.demo.base.MyBaseActivity;
import com.soft2t.imk2tbaseframework.demo.base.MyDbUpgradeHelper;
import com.soft2t.imk2tbaseframework.util.LogUtil;
import com.soft2t.imk2tbaseframework.util.file.DatabaseUtil;

@ContentView(R.layout.activity_splash)
public class SplashActivity extends MyBaseActivity {
    private String downloadUrl = "http://42.56.65.18/dd.myapp.com/16891/7688D452C785349F12FC59DDC16C2A2A.apk?mkey=56d7e483e37fcd84&f=858&fsname=com.dewmobile.kuaiya_3.9.3(CN)_139.apk&p=.apk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LogUtil.e("没有错误啊, 到底打不打印啊!");

        startServer();

        // checkNeedToUpdateOrNot("UpdateGetSerial");

        copyDatabase();
    }

    private void initOthers() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                intentToMain();
            }
        }, Constant.App.HOW_MANY_MILLISECOND_FOR_SPLASH);
    }

    /**
     * 如果没有 数据库的话, 进行创建. 有的话, 进行迭代升级
     */
    private void copyDatabase() {
        DatabaseUtil.smartDo(this, new DatabaseUtil.SmartDatabaseCallback() {
            @Override
            public void onFirstCopyBegin() {
            }

            @Override
            public void onFirstCopySuccess() {
                initOthers();
            }

            @Override
            public void onFirstCopyFail() {
                initOthers();
            }

            @Override
            public void onUpgrade(final int oldVersion, final int newVersion) {
                new DbUpgradeHelper().upgrade(new DatabaseUtil.DbUpgradeCallback() {
                    @Override
                    public void onUpgradeBegin() {
                    }

                    @Override
                    public void onUpgrading() {
                        MyDbUpgradeHelper.doUpgrading(oldVersion, newVersion);
                    }

                    @Override
                    public void onUpgradeSuccess() {
                        initOthers();
                    }

                    @Override
                    public void onUpgradeFail() {
                        initOthers();
                    }
                });
            }

            @Override
            public void onGradeNoChange(int oldVersion) {
                initOthers();
            }
        });
    }

    private void intentToMain() {
        Intent i = new Intent(SplashActivity.this, CatalogActivity.class);

        SplashActivity.this.startActivity(i);

        BaseApplication.MyActivityManager.finishThisActivity(this);
    }

    private void checkNeedToUpdateOrNot(final String actionName) {
        RequestParams params = new RequestParams();
        params.addQueryStringParameter("code", "1234");

        BaseRequestCallBack requestCallBack = new BaseRequestCallBack(actionName) {
            @Override
            public void onBaseSuccess(ResponseInfo<String> responseInfo) {
                parseJsonFromServer(actionName, responseInfo);
            }

            @Override
            public void onBaseFailure(Exception httpException, String msg) {
                MyToastManager.showToast(R.string.checkver_fail);
            }
        };

        BaseWebUrl.makeCall(actionName, params, requestCallBack);
    }

    private void startServer() {
        Intent startDownloadIntent = new Intent(this, UpdateService.class);
        startDownloadIntent.putExtra(UpdateService.APP_NAME, R.string.my_app_name);
        startDownloadIntent.putExtra(UpdateService.ICON, android.R.mipmap.sym_def_app_icon);
        startDownloadIntent.putExtra(UpdateService.URL, downloadUrl);
//        startDownloadIntent.putExtra(UpdateService.FILE_NAME_ONLY, "hello.apk");

        startService(startDownloadIntent);
    }

    private void parseJsonFromServer(String actionName, ResponseInfo<String> responseInfo) {
        startServer();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
