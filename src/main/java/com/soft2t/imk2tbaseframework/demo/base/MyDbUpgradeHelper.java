package com.soft2t.imk2tbaseframework.demo.base;

import android.database.sqlite.SQLiteDatabase;

import com.soft2t.imk2tbaseframework.util.file.DatabaseUtil;

/**
 * Created by imknown on 2016/3/9.
 */
public class MyDbUpgradeHelper {
    public static void doUpgrading(int oldVersion, int newVersion) {
        SQLiteDatabase db = SQLiteDatabase.openDatabase(DatabaseUtil.DATABASE_PATH + DatabaseUtil.DB_NAME, null, SQLiteDatabase.OPEN_READWRITE);

        for (int versionTemp = oldVersion; versionTemp <= newVersion; versionTemp++) {
            switch (versionTemp) {
                case MyBaseApplication.DB_VERSION_2:
                    upgradeToVersion2();
                    break;
                case MyBaseApplication.DB_VERSION_3:
                    upgradeToVersion3();
                    break;
                case MyBaseApplication.DB_VERSION_4:
                    upgradeToVersion4();
                    break;
                case MyBaseApplication.DB_VERSION_5:
                    upgradeToVersion5();
                    break;
                case MyBaseApplication.DB_VERSION_6:
                    upgradeToVersion6();
                    break;
            }
        }

        if (db != null && db.isOpen()) {
            db.close();
        }
    }

    // TODO 这里创建 对应版本 升级的增量SQL
    // region 升级的增量SQL 方法
    private static void upgradeToVersion2() {
    }

    private static void upgradeToVersion3() {
    }

    private static void upgradeToVersion4() {
    }

    private static void upgradeToVersion5() {
    }

    private static void upgradeToVersion6() {
    }
    // endregion
}
