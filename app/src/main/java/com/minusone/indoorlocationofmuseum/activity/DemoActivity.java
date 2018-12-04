package com.minusone.indoorlocationofmuseum.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.minusone.indoorlocationofmuseum.activity.demo.CacheActivtiy;
import com.minusone.indoorlocationofmuseum.activity.demo.CacheImageActivtiy;
import com.minusone.indoorlocationofmuseum.activity.demo.DatabaseActivtiy;
import com.minusone.indoorlocationofmuseum.activity.demo.DownloadActivtiy;
import com.minusone.indoorlocationofmuseum.activity.demo.HttpActivtiy;
import com.minusone.indoorlocationofmuseum.activity.demo.MvcActivtiy;
import com.minusone.indoorlocationofmuseum.activity.demo.OtherActivtiy;
import com.ta.annotation.TAInjectView;

public class DemoActivity extends ActivityBase {
    @TAInjectView(id = R.id.test_db)
    private Button testDBButton;
    @TAInjectView(id = R.id.test_cache)
    private Button testCacheButton;
    @TAInjectView(id = R.id.test_image_cache)
    private Button testImageCacheButton;
    @TAInjectView(id = R.id.test_mvc)
    private Button testMVCCacheButton;
    @TAInjectView(id = R.id.test_http)
    private Button testHTTPCacheButton;
    @TAInjectView(id = R.id.test_download)
    private Button testDownloadButton;
    @TAInjectView(id = R.id.test_other)
    private Button testOtherButton;
    @TAInjectView(id = R.id.exit_app)
    private Button exitAppButton;
    @TAInjectView(id = R.id.signal_scan)
    private Button signalScanButton;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo);

        preActivity=R.string.IndexActivity;
        InitTitleBar();
    }

    @Override
    protected void onAfterOnCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onAfterOnCreate(savedInstanceState);
        setTitle(R.string.thinkandroid_main_title);
    }

    @Override
    protected void onAfterSetContentView() {
        super.onAfterSetContentView();

        OnClickListener onClickListener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                SwitchActivityAndView(v);
            }
        };
        testDBButton.setOnClickListener(onClickListener);
        testCacheButton.setOnClickListener(onClickListener);
        testImageCacheButton.setOnClickListener(onClickListener);
        exitAppButton.setOnClickListener(onClickListener);
        testMVCCacheButton.setOnClickListener(onClickListener);
        testHTTPCacheButton.setOnClickListener(onClickListener);
        testDownloadButton.setOnClickListener(onClickListener);
        testOtherButton.setOnClickListener(onClickListener);
        signalScanButton.setOnClickListener(onClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void SwitchActivityAndView(View v) {
        // TANetworkStateReceiver.checkNetworkState(DemoActivity.this);
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.test_db: {
                intent.setClass(DemoActivity.this, DatabaseActivtiy.class);
                doActivity(R.string.DatabaseActivtiy);
                break;
            }
            case R.id.test_cache: {
                intent.setClass(DemoActivity.this, CacheActivtiy.class);
                doActivity(R.string.CacheActivtiy);
                break;
            }
            case R.id.test_image_cache: {
                intent.setClass(DemoActivity.this, CacheImageActivtiy.class);
                doActivity(R.string.CacheImageActivtiy);
                break;
            }
            case R.id.test_mvc: {
                intent.setClass(DemoActivity.this, MvcActivtiy.class);
                doActivity(R.string.MvcActivtiy);
                break;
            }
            case R.id.test_http: {
                intent.setClass(DemoActivity.this, HttpActivtiy.class);
                doActivity(R.string.HttpActivtiy);
                break;
            }
            case R.id.test_download: {
                intent.setClass(DemoActivity.this, DownloadActivtiy.class);
                doActivity(R.string.DownloadActivtiy);
                break;
            }
            case R.id.test_other: {
                intent.setClass(DemoActivity.this, OtherActivtiy.class);
                doActivity(R.string.OtherActivtiy);
                break;
            }
            case R.id.signal_scan: {
                intent = new Intent();
                intent.setClass(DemoActivity.this, SignalScanActivtiy.class);
                startActivity(intent);
                break;
            }
            case R.id.exit_app: {
                DemoActivity.this.exitApp();
                break;
            }
            default:
                break;
        }
    }
}