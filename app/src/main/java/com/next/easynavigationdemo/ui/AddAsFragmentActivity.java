package com.next.easynavigationdemo.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.next.easynavigation.view.EasyNavigationBar;
import com.next.easynavigationdemo.R;
import com.next.easynavigationdemo.ui.normal.AFragment;
import com.next.easynavigationdemo.ui.normal.BFragment;
import com.next.easynavigationdemo.ui.normal.CFragment;
import com.next.easynavigationdemo.ui.normal.DFragment;
import com.next.easynavigationdemo.ui.normal.EFragment;

import java.util.ArrayList;
import java.util.List;

public class AddAsFragmentActivity extends AppCompatActivity {

    private EasyNavigationBar navigationBar;

    private String[] tabText = {"首页", "发现", "消息", "我的"};
    //未选中icon
    private int[] normalIcon = {R.mipmap.index, R.mipmap.find, R.mipmap.message, R.mipmap.me};
    //选中时icon
    private int[] selectIcon = {R.mipmap.index1, R.mipmap.find1, R.mipmap.message1, R.mipmap.me1};

    private List<Fragment> fragments = new ArrayList<>();
    private Handler mHandler = new Handler();

    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        navigationBar = findViewById(R.id.navigationBar);

        fragments.add(new AFragment());
        fragments.add(new BFragment());
        fragments.add(new CFragment());
        fragments.add(new DFragment());
        fragments.add(new EFragment());

        navigationBar.titleItems(tabText)
                .normalIconItems(normalIcon)
                .selectIconItems(selectIcon)
                .fragmentList(fragments)
                .centerImageRes(R.mipmap.add_image)
                .centerTextStr("发布")
                .anim(null)
                .centerLayoutRule(EasyNavigationBar.RULE_BOTTOM)
                .centerLayoutBottomMargin(0)
                .centerAlignBottom(true)
                .fragmentManager(getSupportFragmentManager())
                .setOnTabClickListener(new EasyNavigationBar.OnTabClickListener() {
                    @Override
                    public boolean onTabSelectEvent(View view, int position) {
                        return false;
                    }

                    @Override
                    public boolean onTabReSelectEvent(View view, int position) {
                        return false;
                    }

                })
                .setOnCenterTabClickListener(new EasyNavigationBar.OnCenterTabSelectListener() {
                    @Override
                    public boolean onCenterTabSelectEvent(View view) {
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                //＋ 旋转动画
                                if (flag) {
                                    navigationBar.getCenterImage().animate().rotation(45).setDuration(400);
                                } else {
                                    navigationBar.getCenterImage().animate().rotation(0).setDuration(400);
                                }
                                flag = !flag;
                            }
                        });
                        return false;
                    }
                })
                .canScroll(true)
                .mode(EasyNavigationBar.NavigationMode.MODE_ADD)
                .build();
    }

}
