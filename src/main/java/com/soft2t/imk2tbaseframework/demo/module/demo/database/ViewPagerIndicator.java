package com.soft2t.imk2tbaseframework.demo.module.demo.database;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

//import com.sfytech.weidian.R;

/**
 * Created by Nelson on 2015/11/12. E-mail:yuchen.niu@sfytech.com What:自定义ViewPagerIndicator
 */
public class ViewPagerIndicator extends LinearLayout {
	private ViewPager vp;// 需要绑定的viewpager
	private Drawable CurrentImg;// 当前指示器图片
	private Drawable BackImg;// 背景指示器图片
	private int count = 0;// 页面数

	public ViewPagerIndicator(Context context) {
		super(context);
	}

	public ViewPagerIndicator(Context context, AttributeSet attrs) {
		super(context, attrs);

		// TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.ViewPagerIndicator);
		// CurrentImg = array.getDrawable(R.styleable.ViewPagerIndicator_CurrentImg);
		// BackImg = array.getDrawable(R.styleable.ViewPagerIndicator_BackImg);
		// array.recycle();
	}

	// public ViewPagerIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
	// super(context, attrs, defStyleAttr);
	// TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.ViewPagerIndicator,defStyleAttr,0);
	// CurrentImg = array.getDrawable(R.styleable.ViewPagerIndicator_CurrentImg);
	// BackImg = array.getDrawable(R.styleable.ViewPagerIndicator_BackImg);
	// array.recycle();
	// }

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
		for (int i = 0; i < count; i++) {
			View v = getChildAt(i);
			int size = MeasureSpec.getSize(heightMeasureSpec);
			int measureSpec = MeasureSpec.makeMeasureSpec(size, MeasureSpec.EXACTLY);
			v.measure(measureSpec, measureSpec);
		}
	}

	public void setVp(ViewPager vp) {
		this.vp = vp;
		vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

			}

			@Override
			public void onPageSelected(int position) {
				setCurrentItem(position);
			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});
		count = vp.getAdapter().getCount();
		for (int i = 0; i < count; i++) {
			ImageView imageView = new ImageView(getContext());
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setImageDrawable(BackImg);
			addView(imageView);
		}
		setCurrentItem(vp.getCurrentItem());
	}

	private void setCurrentItem(int position) {
		clear();
		ImageView v = (ImageView) getChildAt(position);
		v.setImageDrawable(CurrentImg);

	}

	private void clear() {
		for (int i = 0; i < count; i++) {
			ImageView v = (ImageView) getChildAt(i);
			v.setImageDrawable(BackImg);
		}
	}

	public void setBackImg(Drawable backImg) {
		BackImg = backImg;
	}

	public void setCurrentImg(Drawable currentImg) {
		CurrentImg = currentImg;
	}
}
