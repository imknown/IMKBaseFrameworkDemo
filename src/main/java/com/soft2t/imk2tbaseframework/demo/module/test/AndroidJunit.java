package com.soft2t.imk2tbaseframework.demo.module.test;

import android.content.Context;
import android.test.AndroidTestCase;
import junit.framework.Assert;

public class AndroidJunit extends AndroidTestCase {

	Context mContext = getContext();

	public void testFalse() {
		Assert.assertTrue(false);
	}

	public void testTrue() {
		Assert.assertTrue(true);
	}
}
