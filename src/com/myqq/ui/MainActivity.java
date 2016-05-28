package com.myqq.ui;

import java.util.ArrayList;
import java.util.List;

import adapater.my_adapter;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.model.messagemodel;

public class MainActivity extends Activity {

    private ListView lv;

    private List<messagemodel> list;

    private my_adapter madapter;

    private LayoutInflater inflater;

    private boolean isCancelAble = false;

    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.id_listview);

        getdata();
        inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.top_file, null);
        lv.addHeaderView(view);

        madapter = new my_adapter(this, list);
        lv.setAdapter(madapter);
        addListener();

    }

    private void addListener() {
        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                    long arg3) {
                Toast.makeText(MainActivity.this, "你点了我！！！", Toast.LENGTH_SHORT)
                        .show();

                ProgressDialog.show(MainActivity.this, "进入中......", null, true,
                        !isCancelAble);
            }
        });
        lv.setOnItemLongClickListener(new OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                    int arg2, long arg3) {
                dialog = ProgressDialog.show(MainActivity.this, "yy", "xxxxx",
                        true, !isCancelAble);
                return true;
            }
        });
        lv.setOnScrollListener(new OnScrollListener() {

            public void onScrollStateChanged(AbsListView arg0, int arg1) {
                switch (arg1) {
                case SCROLL_STATE_FLING:
                    Toast.makeText(MainActivity.this, "抛动中......", 500).show();

                    break;
                case SCROLL_STATE_IDLE:

                    Toast.makeText(MainActivity.this, "停止操作", 500).show();

                    break;
                case SCROLL_STATE_TOUCH_SCROLL:
                    Toast.makeText(MainActivity.this, "翻滚中......", 500).show();

                    break;

                default:
                    break;
                }

            }

            public void onScroll(AbsListView arg0, int arg1, int arg2, int arg3) {

            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {

            dialog.dismiss();
        }
        return super.onKeyDown(keyCode, event);

    }

    private void getdata() {
        list = new ArrayList<messagemodel>();

        messagemodel model1 = new messagemodel(true, R.drawable.mcv, "猫星人",
                R.drawable.ic_chevron_right_grey600_24dp, false);
        messagemodel model2 = new messagemodel(false, R.drawable.nef, "京东购物",
                R.drawable.ic_chevron_right_grey600_24dp, false);
        messagemodel model3 = new messagemodel(false, R.drawable.gri, "音乐",
                R.drawable.ic_chevron_right_grey600_24dp, true);
        messagemodel model4 = new messagemodel(false, R.drawable.liu, "健康",
                R.drawable.ic_chevron_right_grey600_24dp, false);
        messagemodel model5 = new messagemodel(false, R.drawable.lio, "附近的群",
                R.drawable.ic_chevron_right_grey600_24dp, false);
        messagemodel model6 = new messagemodel(false, R.drawable.idl, "大众点评",
                R.drawable.ic_chevron_right_grey600_24dp, false);
        messagemodel model7 = new messagemodel(false, R.drawable.liz, "健身空间",
                R.drawable.ic_chevron_right_grey600_24dp, false);
        messagemodel model8 = new messagemodel(false, R.drawable.lje, "支付空间",
                R.drawable.ic_chevron_right_grey600_24dp, false);
        messagemodel model9 = new messagemodel(false, R.drawable.lin, "看点",
                R.drawable.ic_chevron_right_grey600_24dp, false);
        messagemodel model10 = new messagemodel(false, R.drawable.lis, "游戏",
                R.drawable.ic_chevron_right_grey600_24dp, false);
        messagemodel model11 = new messagemodel(true, R.drawable.lix, "ͬ独家新闻",
                R.drawable.ic_chevron_right_grey600_24dp, false);
        messagemodel model12 = new messagemodel(false, R.drawable.lnb, "阅读",
                R.drawable.ic_chevron_right_grey600_24dp, false);
        messagemodel model13 = new messagemodel(false, R.drawable.liw, "名片夹",
                R.drawable.ic_chevron_right_grey600_24dp, false);
        list.add(model1);
        list.add(model2);
        list.add(model3);
        list.add(model4);
        list.add(model5);
        list.add(model6);
        list.add(model7);
        list.add(model8);
        list.add(model9);
        list.add(model10);
        list.add(model11);
        list.add(model12);
        list.add(model13);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
