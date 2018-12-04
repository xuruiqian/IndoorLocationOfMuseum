package com.minusone.indoorlocationofmuseum.activity;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.minusone.indoorlocationofmuseum.adapter.FragAdapter;
import com.minusone.indoorlocationofmuseum.usercontrol.TitleBar;

import java.util.ArrayList;
import java.util.List;

//public class IndexActivity extends AppCompatActivity {
public class IndexActivity extends ActivityBase {
    private static final String TAG = "IndexActivity";
    private ViewPager viewPager;
    private BottomNavigationView navigation;//底部导航栏对象
    private List<Fragment> listFragment;//存储页面对象
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home: {
                    viewPager.setCurrentItem(0);
                    return true;
                }
                case R.id.navigation_locateguide: {
                    viewPager.setCurrentItem(1);
                    return true;
                }
                case R.id.navigation_settings: {
                    viewPager.setCurrentItem(2);
                    return true;
                }
            }
            return false;
        }
    };

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);

        preActivity=R.string.IndexActivity;
        InitTitleBar();

        initView();//初始化
    }

    private void initView() {
        //向ViewPager添加各页面
        listFragment = new ArrayList<>();
        listFragment.add(new IndexHomeFragment());
        listFragment.add(new IndexLocateGuideFragment());
        listFragment.add(new IndexSettingsFragment());
        FragAdapter myAdapter = new FragAdapter(getSupportFragmentManager(), this, listFragment);
        viewPager.setAdapter(myAdapter);

        //导航栏点击事件和ViewPager滑动事件,让两个控件相互关联
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home: {
                        viewPager.setCurrentItem(0);
                        return true;
                    }
                    case R.id.navigation_locateguide: {
                        viewPager.setCurrentItem(1);
                        return true;
                    }
                    case R.id.navigation_settings: {
                        viewPager.setCurrentItem(2);
                        return true;
                    }
                }
                return false;
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //注意这个方法滑动时会调用多次，下面是参数解释：
                //position当前所处页面索引,滑动调用的最后一次绝对是滑动停止所在页面
                //positionOffset:表示从位置的页面偏移的[0,1]的值。
                //positionOffsetPixels:以像素为单位的值，表示与位置的偏移
            }

            @Override
            public void onPageSelected(int position) {
                //该方法只在滑动停止时调用，position滑动停止所在页面位置
                //当滑动到某一位置，导航栏对应位置被按下
                navigation.getMenu().getItem(position).setChecked(true);
                //这里使用navigation.setSelectedItemId(position);无效，
                //setSelectedItemId(position)的官网原句：Set the selected
                // menu item ID. This behaves the same as tapping on an item
                //未找到原因
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // 这个方法在滑动是调用三次，分别对应下面三种状态
                // 这个方法对于发现用户何时开始拖动，
                // 何时寻呼机自动调整到当前页面，或何时完全停止/空闲非常有用。
                // state表示新的滑动状态，有三个值：
                // SCROLL_STATE_IDLE：开始滑动（空闲状态->滑动），实际值为0
                // SCROLL_STATE_DRAGGING：正在被拖动，实际值为1
                // SCROLL_STATE_SETTLING：拖动结束,实际值为2
            }
        });
    }
}