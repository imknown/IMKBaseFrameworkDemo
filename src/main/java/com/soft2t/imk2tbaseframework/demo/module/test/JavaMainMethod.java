package com.soft2t.imk2tbaseframework.demo.module.test;

import com.soft2t.imk2tbaseframework.util.date.DateUtil;

public class JavaMainMethod {

	public static void main(String[] args) {
		String date1 = "2014-01-01 00:00";
		String date2 = "2015-01-01 00:00";

		long days = DateUtil.getDays(date1, date2);

		System.out.println(days);
	}
}