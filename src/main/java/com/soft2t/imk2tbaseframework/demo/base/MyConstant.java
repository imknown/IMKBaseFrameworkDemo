package com.soft2t.imk2tbaseframework.demo.base;

import com.soft2t.imk2tbaseframework.base.Constant;

public class MyConstant {

	// URL ================
	public static final String DEBUG_STATIC_HEAD = "sd";
	public static final String RELEASE_STATIC_HEAD = "sr";

	public static String getStaticFixUrl(String whatAspx) {
		String url = Constant.Net.SCHEMA;

		if (Constant.Debug.SHOW_DEVELOP_LOG) {
			url += DEBUG_STATIC_HEAD;
		} else {
			url += RELEASE_STATIC_HEAD;
		}

		url += ".imknown.net" + ":" + Constant.Net.TOMCAT_PORT + Constant.SLASH + whatAspx;

		return url;
	}

	public static final String DEBUG_HEAD = "d";
	public static final String RELEASE_HEAD = "r";

	public static String getFixUrl(String whatAspx) {
		String url = Constant.Net.SCHEMA;

		if (Constant.Debug.SHOW_DEVELOP_LOG) {
			url += DEBUG_HEAD;
		} else {
			url += RELEASE_HEAD;
		}

		url += ".imknown.net" + ":" + Constant.Net.TOMCAT_PORT + Constant.SLASH + whatAspx;

		return url;
	}
}
