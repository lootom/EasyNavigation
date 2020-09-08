package com.next.easynavigationdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.next.easynavigation.view.EasyNavigationBar;
import com.next.easynavigationdemo.R;
import com.next.easynavigationdemo.ui.normal.AFragment;
import com.next.easynavigationdemo.ui.normal.BFragment;
import com.next.easynavigationdemo.ui.normal.CFragment;
import com.next.easynavigationdemo.ui.normal.DFragment;

import java.util.ArrayList;
import java.util.List;

public class OnlyNavigationActivity extends AppCompatActivity {

    private EasyNavigationBar navigationBar;

    private String[] tabText = {"首页", "发现", "消息", "我的"};
    //未选中icon
    private int[] normalIcon = {R.mipmap.index, R.mipmap.find, R.mipmap.message, R.mipmap.me};
    //选中时icon
    private int[] selectIcon = {R.mipmap.index1, R.mipmap.find1, R.mipmap.message1, R.mipmap.me1};

    private List<android.support.v4.app.Fragment> fragments = new ArrayList<>();

    private TextView tv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_only_navigation);

        navigationBar = findViewById(R.id.navigationBar);
        tv_content = findViewById(R.id.tv_content);

        fragments.add(new AFragment());
        fragments.add(new BFragment());
        fragments.add(new CFragment());
        fragments.add(new DFragment());

        navigationBar.titleItems(tabText)
                .normalIconItems(normalIcon)
                .selectIconItems(selectIcon)
                .build();

        navigationBar.setOnTabClickListener(new EasyNavigationBar.OnTabClickListener() {

            @Override
            public boolean onTabSelectEvent(View view, int position) {
                tv_content.setText("您点击了第"+position+"个Tab，这里面没有Fragment的、只是单纯的点击");
                return false;
            }

            @Override
            public boolean onTabReSelectEvent(View view, int position) {
                Toast.makeText(OnlyNavigationActivity.this,"重复点击",Toast.LENGTH_SHORT).show();
                return false;
            }

        });
    }


}
