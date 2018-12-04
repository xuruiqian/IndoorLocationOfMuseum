package com.minusone.indoorlocationofmuseum.activity;

import com.minusone.indoorlocationofmuseum.activity.demo.CacheActivtiy;
import com.minusone.indoorlocationofmuseum.activity.demo.DatabaseActivtiy;
import com.minusone.indoorlocationofmuseum.activity.demo.DownloadActivtiy;
import com.minusone.indoorlocationofmuseum.activity.demo.HttpActivtiy;
import com.minusone.indoorlocationofmuseum.activity.demo.CacheImageActivtiy;
import com.minusone.indoorlocationofmuseum.activity.demo.DownloadMultiThreadActivtiy;
import com.minusone.indoorlocationofmuseum.activity.demo.MvcActivtiy;
import com.minusone.indoorlocationofmuseum.activity.demo.OtherActivtiy;
import com.minusone.indoorlocationofmuseum.activity.demo.DownloadSimpleActivtiy;
import com.minusone.indoorlocationofmuseum.activity.demo.DownloadSimpleTwoActivtiy;
import com.minusone.indoorlocationofmuseum.command.TestMVCCommand;
import com.ta.TAApplication;
import com.ta.util.cache.TAFileCache;
import com.ta.util.cache.TAFileCache.TACacheParams;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/**
 * 启动引导界面
 */
public class SplashActivity extends ActivityBase {
    private static final String SYSTEMCACHE = "thinkandroid";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        // TANetworkStateReceiver.registerNetworkStateReceiver(this);
        final View view = View.inflate(this, R.layout.splash, null);
        setContentView(view);
        // 渐变展示启动屏
        AlphaAnimation aa = new AlphaAnimation(0.5f, 1.0f);
        aa.setDuration(3000);//开始界面等待三秒
        view.startAnimation(aa);
        aa.setAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationEnd(Animation arg0) {
                startMain();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationStart(Animation animation) {
            }
        });
    }

    @Override
    protected void onPreOnCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onPreOnCreate(savedInstanceState);
        TAApplication application = (TAApplication) getApplication();
        // 配置系统的缓存,可以选择性的配置
        TACacheParams cacheParams = new TACacheParams(this, SYSTEMCACHE);
        TAFileCache fileCache = new TAFileCache(cacheParams);
        application.setFileCache(fileCache);

        // 注册activity
        //getTAApplication().registerActivity(R.string.IndexActivity, IndexActivity.class);
        getTAApplication().registerActivity(R.string.DemoActivity, DemoActivity.class);
        getTAApplication().registerActivity(R.string.SignalScanActivtiy, SignalScanActivtiy.class);
        getTAApplication().registerActivity(R.string.SettingsActivity, SettingsActivity.class);

        // 注册activity
        getTAApplication().registerCommand(R.string.testmvccommand, TestMVCCommand.class);

        getTAApplication().registerActivity(R.string.CacheActivtiy, CacheActivtiy.class);
        getTAApplication().registerActivity(R.string.DatabaseActivtiy, DatabaseActivtiy.class);
        getTAApplication().registerActivity(R.string.CacheImageActivtiy, CacheImageActivtiy.class);
        getTAApplication().registerActivity(R.string.MvcActivtiy, MvcActivtiy.class);
        getTAApplication().registerActivity(R.string.HttpActivtiy, HttpActivtiy.class);
        getTAApplication().registerActivity(R.string.DownloadSimpleActivtiy, DownloadSimpleActivtiy.class);
        getTAApplication().registerActivity(R.string.DownloadSimpleTwoActivtiy, DownloadSimpleTwoActivtiy.class);
        getTAApplication().registerActivity(R.string.DownloadActivtiy, DownloadActivtiy.class);
        getTAApplication().registerActivity(R.string.DownloadMultiThreadActivtiy, DownloadMultiThreadActivtiy.class);
        getTAApplication().registerActivity(R.string.OtherActivtiy, OtherActivtiy.class);

    }

    @Override
    protected void onAfterOnCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onAfterOnCreate(savedInstanceState);
    }

    private void startMain() {
        // TODO Auto-generated method stu
        doActivity(R.string.IndexActivity);
        //doActivity(R.string.DemoActivity);

        Intent intent = new Intent();
        intent.setClass(SplashActivity.this, IndexActivity.class);
        startActivity(intent);
    }
}