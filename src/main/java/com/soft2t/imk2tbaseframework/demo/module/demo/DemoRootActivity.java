package com.soft2t.imk2tbaseframework.demo.module.demo;

import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.widget.TextView;

import com.soft2t.imk2tbaseframework.demo.R;
import com.soft2t.imk2tbaseframework.demo.base.MyBaseActivity;
import com.soft2t.imk2tbaseframework.util.device.soft.ShellUtils;
import com.soft2t.imk2tbaseframework.util.device.soft.ShellUtils.CommandResult;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DemoRootActivity extends MyBaseActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_root);

        tv = (TextView) findViewById(R.id.tv);

        // ==============================================

        ShellUtils.COMMAND_SU_PREFIX = ShellUtils.COMMAND_SU;

        tv.setText(tv.getText().toString() + "\n");
        tv.setText(tv.getText().toString() + "\n" + "是否有 " + ShellUtils.COMMAND_SU_PREFIX + " Root 权限 : " + ShellUtils.checkRootPermission());

        // ==============================================

        String cmd = "adb version";
        CommandResult cr = ShellUtils.execCommand(cmd, false);
        printLog(cmd, cr);

        // ==============================================

        cmd = "mkdir /sdcard/1_test/" + DateFormat.format("yyyy-MM-dd_kk-mm-ss", new Date());
        cr = ShellUtils.execCommand(cmd, false);
        printLog(cmd, cr);

        // ==============================================

        cmd = "rm -rf /data/data/1111111";
        cr = ShellUtils.execCommand(cmd, true);
        printLog(cmd, cr);

        cmd = "mkdir /data/data/1111111";
        cr = ShellUtils.execCommand(cmd, true);
        printLog(cmd, cr);

        // ==============================================

        cmd = "utsu 0 rm -rf /data/data/1111111";
        cr = ShellUtils.execCommand(cmd, false);
        printLog(cmd, cr);

        cmd = "utsu 0 mkdir /data/data/1111111";
        cr = ShellUtils.execCommand(cmd, false);
        printLog(cmd, cr);

        ArrayList<Person> personList = getIntent().getParcelableArrayListExtra(DemoParcelableActivity.Key);
        if (personList != null) {
            for (Person person : personList) {
                tv.setText(tv.getText().toString() + "\n");
                tv.setText(tv.getText().toString() + "\n" + "person.getName()= " + person.getName());

                List<Pet> petList = person.getPetList();
                if (petList == null) {
                    continue;
                }

                for (Pet pet : person.getPetList()) {
                    tv.setText(tv.getText().toString() + "\n" + "pet.getName()= " + pet.getKind() + ": " + pet.getName());
                }
            }
        }
    }

    private void printLog(String cmd, CommandResult cr) {
        tv.setText(tv.getText().toString() + "\n");

        tv.setText(tv.getText().toString() + "\n" + "cmd = " + cmd);

        tv.setText(tv.getText().toString() + "\n" + "result = " + cr.result);

        if (!TextUtils.isEmpty(cr.successMsg)) {
            tv.setText(tv.getText().toString() + "\n" + "successMsg = " + cr.successMsg);
        }

        if (!TextUtils.isEmpty(cr.errorMsg)) {
            tv.setText(tv.getText().toString() + "\n" + "errorMsg = " + cr.errorMsg);
        }
    }
}
