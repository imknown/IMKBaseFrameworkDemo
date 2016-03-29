package com.soft2t.imk2tbaseframework.demo.module.demo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.soft2t.imk2tbaseframework.demo.R;
import com.soft2t.imk2tbaseframework.demo.base.MyBaseActivity;

@ContentView(R.layout.activity_demo_show_image)
public class DemoShowImageActivity extends MyBaseActivity {

	@ViewInject(R.id.web_show_src_imgv)
	private ImageView web_show_src_imgv;

	@ViewInject(R.id.web_show_null_imgv)
	private ImageView web_show_null_imgv;

	private String showSrcURL = "http://p3.so.qhimg.com/bdr/_240_/t010e0d92e000ab62cd.jpg";
	private String showNullURL = "http://p3.so.qhimg.com/bdr/_240_/t01459f3993e3c076bd.jpg";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ImageLoader imageLoader = ImageLoader.getInstance();

		DisplayImageOptions showSrcDisplayImageOptions = createShowSrcDisplayImageOptions();
		imageLoader.displayImage(showSrcURL, web_show_src_imgv, showSrcDisplayImageOptions);

		DisplayImageOptions showNullDisplayImageOptions = createShowNullDisplayImageOptions();
		imageLoader.displayImage(showNullURL, web_show_null_imgv, showNullDisplayImageOptions);
	}

	private DisplayImageOptions createShowSrcDisplayImageOptions() {
		DisplayImageOptions options = new DisplayImageOptions.Builder()//
				// .showImageOnLoading(R.drawable.ic_launcher)// 加载中
				// .showImageForEmptyUri(R.drawable.ic_launcher)// 空地址
				// .showImageOnFail(R.drawable.ic_launcher)// 失败的图片
				// .cacheInMemory(true)// 内存缓存
				// .cacheOnDisk(true)// 磁盘缓存
				.resetViewBeforeLoading(false)// 重置 控件 原有的 src
				.considerExifParams(true)// 是否考虑JPEG图像EXIF参数(旋转，翻转等)
				.bitmapConfig(Bitmap.Config.RGB_565)//
				// .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)// 设置图片以如何的编码方式显示
				// .resetViewBeforeLoading(true)// 设置图片在下载前, 是否 重置/复位
				// .decodingOptions(android.graphics.BitmapFactory.Options decodingOptions)// 设置图片的解码配置
				// .delayBeforeLoading(100)// 你设置的下载前的延迟时间
				// .displayer(new RoundedBitmapDisplayer(20))// 是否设置为圆角，弧度为多少
				// .displayer(new FadeInBitmapDisplayer(100))// 是否图片加载好后渐入的动画时间
				.build();

		return options;
	}

	private DisplayImageOptions createShowNullDisplayImageOptions() {
		DisplayImageOptions options = new DisplayImageOptions.Builder()//
				// .showImageOnLoading(R.drawable.ic_launcher)// 加载中
				// .showImageForEmptyUri(R.drawable.ic_launcher)// 空地址
				// .showImageOnFail(R.drawable.ic_launcher)// 失败的图片
				// .cacheInMemory(true)// 内存缓存
				// .cacheOnDisk(true)// 磁盘缓存
				.resetViewBeforeLoading(true)// 重置 控件 原有的 src
				.considerExifParams(true)// 是否考虑JPEG图像EXIF参数(旋转，翻转等)
				.bitmapConfig(Bitmap.Config.RGB_565)//
				// .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)// 设置图片以如何的编码方式显示
				// .resetViewBeforeLoading(true)// 设置图片在下载前, 是否 重置/复位
				// .decodingOptions(android.graphics.BitmapFactory.Options decodingOptions)// 设置图片的解码配置
				// .delayBeforeLoading(100)// 你设置的下载前的延迟时间
				// .displayer(new RoundedBitmapDisplayer(20))// 是否设置为圆角，弧度为多少
				// .displayer(new FadeInBitmapDisplayer(100))// 是否图片加载好后渐入的动画时间
				.build();

		return options;
	}
}
