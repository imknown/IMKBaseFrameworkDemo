package com.soft2t.imk2tbaseframework.demo.module.demo;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.soft2t.imk2tbaseframework.base.BaseApplication.MyToastManager;
import com.soft2t.imk2tbaseframework.base.BaseRequestCallBack;
import com.soft2t.imk2tbaseframework.base.BaseWebUrl;
import com.soft2t.imk2tbaseframework.demo.R;
import com.soft2t.imk2tbaseframework.demo.base.MyBaseActivity;
import com.soft2t.imk2tbaseframework.demo.module.demo.adapter.DemoAdapterActivity;

@SuppressWarnings({ "deprecation", "unused" })
@ContentView(R.layout.activity_demo_make_call)
public class DemoMakeCallActivity extends MyBaseActivity {

	@ViewInject(R.id.telephone_Et)
	private EditText telephone_Et;
	@ViewInject(R.id.password_Et)
	private EditText password_Et;

	@OnClick(R.id.sign_in_btn)
	private void signIn(View view) {
		makeCall("UserLogin");
	}

	private void makeCall(final String actionName) {

		String telephone = telephone_Et.getText().toString();
		String password = password_Et.getText().toString();

		RequestParams params = new RequestParams();
		params.addQueryStringParameter("telephone", telephone);
		params.addQueryStringParameter("password", password);

		BaseRequestCallBack requestCallBack = new BaseRequestCallBack(actionName) {
			@Override
			public void onBaseSuccess(ResponseInfo<String> responseInfo) {
				parseJsonFromServer(actionName, responseInfo);
			}

			@Override
			public void onBaseFailure(Exception error, String msg) {
				MyToastManager.showToast(msg);
			}
		};

		BaseWebUrl.makeCall(actionName, params, requestCallBack);
	}

	private void parseJsonFromServer(String actionName, ResponseInfo<String> responseInfo) {
		// 在这里 继续
		String jsonString = responseInfo.result;

		JSONObject fastjsonObject = JSON.parseObject(jsonString);

		// 在这里 继续
		MyToastManager.showToast("登录成功");

		Intent intent = new Intent(this, DemoAdapterActivity.class);
		startActivity(intent);
	}
}