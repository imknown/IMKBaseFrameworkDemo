package com.soft2t.imk2tbaseframework.demo.module.demo.comment;

import java.util.Arrays;
import java.util.List;

import android.widget.ListView;

/**
 * 这个 类 是做什么用的<br/>
 * {@code System.out.print()} ← 代码<br/>
 * 
 * @version 1.5.23_r46
 * @since 1.0.0
 * @author 作者
 * @see {@link Test} ← 点我试试看<br/>
 */
public class DemoComment {

	/** 成员变量 多处使用, 可以考虑 前面写上 m, 代表 Member */
	public int mCommentType;

	/**
	 * @hide 123456789
	 * @author imknown
	 */
	public static final int hideField = 0;

	/** 外部  不可见 */
	/* package */int invalidField = 0;

	public List<Integer> intList = Arrays.asList( //
			0x0, 0x1, 0x2, 0x3, 0x4, //
			0x5, 0x6, 0x7, 0x8, //
			0x9, 0xA, 0xB, //
			0xC, 0xD, //
			0xE);

	public String hi = "000000" + //
			"111111" + //
			"22222" + //
			"3333" + //
			"444" + //
			"55" + //
			"6";//

	/**
	 * 成员变量 的 注释<br />
	 * <font color=red>红色文字</font><br />
	 * <font color=blue>蓝色文字</font><br />
	 * <font color="#66CCAA">自定义颜色文字</font><br />
	 */
	public ListView info_lv;

	// TODO 以后要做的事情
	// FIXME 这里有问题
	// XXX 其他事项
	/**
	 * 根据号码获取名字
	 * 
	 * @deprecated 请使用 {@link #getNameByNumber(int number)} ← 点我试一试
	 * 
	 * @param number
	 *            号码
	 * @return 名字
	 */
	@Deprecated
	public String getName(int number) {

		/**
		 * 换了一行, 不怕格式化<br />
		 * 换了一行, 不怕格式化<br >
		 * 换了一行, 不怕格式化
		 */
		// 换了一行, 不怕格式化
		// 换了一行, 不怕格式化
		// 换了一行, 不怕格式化
		String mingzi = "";

		// 下一行的注释
		return mingzi;// 注释最好不要写在最后面
	}

	/**
	 * 根据号码获取名字
	 * 
	 * @param number
	 *            号码
	 */
	public String getNameByNumber(int number) {
		return "";
	}
}

/** 看到你了 */
class Test {
}