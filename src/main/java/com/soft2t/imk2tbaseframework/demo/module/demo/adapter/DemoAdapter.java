package com.soft2t.imk2tbaseframework.demo.module.demo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.soft2t.imk2tbaseframework.base.BaseApplication.MyToastManager;
import com.soft2t.imk2tbaseframework.base.BaseBaseAdapter;
import com.soft2t.imk2tbaseframework.demo.R;
import com.soft2t.imk2tbaseframework.demo.module.demo.adapter.DemoAdapter.MyHolder;

import java.util.List;

public class DemoAdapter extends BaseBaseAdapter<MyData, MyHolder> {

    private Context context;
    private int layoutResId;
    private List<MyData> list;

    public DemoAdapter(Context context, List<MyData> list, int layoutResId) {
        super(context, list, layoutResId);

        this.context = context;
        this.layoutResId = layoutResId;
        this.list = list;

        super.viewCallback = new ViewCallback() {
            // @Override
            // protected int getViewId() {
            // return CoverAdapter.this.layoutResId;
            // }

            @Override
            protected MyHolder getViewHolder(View view, int position) {
                MyHolder holder = new MyHolder();

                return holder;
            }

            @Override
            protected void initView(MyHolder holder, int position) {
                MyData myData = getItem(position);

                if (myData != null) {
                    holder.name_tv.setText(myData.name);

                    String colorString = "";
                    if (position % 2 == 0) {
                        colorString = "#0000AA";
                    } else {
                        colorString = "#00AA00";
                    }

                    holder.name_tv.setTextColor(Color.parseColor(colorString));
                }
            }
        };
    }

    public class MyHolder {
        @ViewInject(R.id.name_tv)
        public TextView name_tv;

        @OnClick(R.id.name_tv)
        public void showItemName(View view) {
            String s = ((TextView) view).getText().toString();

            MyToastManager.showToast(" 控件点击: " + s);
        }
    }
}

class MyData {
    public String name;
}
