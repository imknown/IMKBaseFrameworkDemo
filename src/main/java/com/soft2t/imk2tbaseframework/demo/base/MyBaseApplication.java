package com.soft2t.imk2tbaseframework.demo.base;

import com.soft2t.imk2tbaseframework.base.BaseApplication;
import com.soft2t.imk2tbaseframework.base.Constant;

public class MyBaseApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        initConstant();

        boolean isMain = super.initBase();

        if (isMain) {

        }
    }

    private void initConstant() {
        mApplicationContext = this;

        Constant.App.PACKAGE_NAME = getPackageName();

        Constant.Debug.SHOW_DEVELOP_LOG = true;
        Constant.Debug.ENABLE_STRICT_MODE = false;

        if (Constant.Debug.SHOW_DEVELOP_LOG) {
            Constant.Net.TOMCAT_IP = MyConstant.DEBUG_HEAD + ".cnyanglao.com";
        } else {
            Constant.Net.TOMCAT_IP = MyConstant.RELEASE_HEAD + ".cnyanglao.com";
        }
        Constant.Net.TOMCAT_PORT = "80";
        Constant.Net.PROJECT_NAME = "PhoneService.aspx";

        Constant.Db.DB_NAME = "IMK2TBaseFrameworkDemo.sqlite";
        Constant.Db.DB_VERSION = DB_VERSION_1; // TODO 数据库有更改, 需要修改这里
        Constant.Db.EXISTS_FOR_CHECKING = Constant.Db.EXISTS_FOR_CHECKING_DEFAULT;
    }
}
