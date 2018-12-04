package com.minusone.indoorlocationofmuseum.activity.demo;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.minusone.indoorlocationofmuseum.activity.ActivityBase;
import com.minusone.indoorlocationofmuseum.activity.R;
import com.ta.TAActivity;
import com.ta.annotation.TAInjectView;
import com.ta.util.TALogger;
import com.ta.util.cache.TAExternalOverFroyoUtils;
import com.ta.util.http.AsyncHttpClient;
import com.ta.util.http.FileHttpResponseHandler;

public class DownloadSimpleActivtiy extends ActivityBase {
    final static String DOWNLOAD_DIR = "download";
    @TAInjectView(id = R.id.textview)
    private TextView textView;
    @TAInjectView(id = R.id.start)
    private Button startButton;
    @TAInjectView(id = R.id.stop)
    private Button stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demodownloadsimple);

        preActivity=R.string.DemoActivity;
        InitTitleBar();
    }

    @Override
    protected void onAfterOnCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onAfterOnCreate(savedInstanceState);
        setTitle(R.string.thinkandroid_simple_download_title);
    }

    @Override
    protected void onAfterSetContentView() {
        // TODO Auto-generated method stub
        super.onAfterSetContentView();
        final AsyncHttpClient syncHttpClient = new AsyncHttpClient();
        final FileHttpResponseHandler fileHttpResponseHandler = new FileHttpResponseHandler(
                TAExternalOverFroyoUtils.getDiskCacheDir(
                        DownloadSimpleActivtiy.this, DOWNLOAD_DIR)
                        .getAbsolutePath()) {

            @Override
            public void onProgress(long totalSize, long currentSize, long speed) {
                // TODO Auto-generated method stub
                super.onProgress(totalSize, currentSize, speed);
                long downloadPercent = currentSize * 100 / totalSize;
                textView.setText(downloadPercent + "--------" + speed + "kbps");
                TALogger.v(DownloadSimpleActivtiy.this,
                        downloadPercent + "--------" + speed);
            }

            @Override
            public void onFailure(Throwable error) {
                // TODO Auto-generated method stub
                super.onFailure(error);
                textView.setText("下载失败！");
            }

            @Override
            public void onSuccess(byte[] binaryData) {
                // TODO Auto-generated method stub
                super.onSuccess(binaryData);
                textView.setText("下载成功！");
            }
        };
        OnClickListener onClickListener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                switch (v.getId()) {
                    case R.id.start:
                        startCom();
                        break;
                    case R.id.stop:
                        stopCom();
                        break;
                    default:
                        break;
                }

            }

            private void startCom() {
                // TODO Auto-generated method stub
                fileHttpResponseHandler.setInterrupt(false);
                syncHttpClient
                        .download(
                                "http://static.qiyi.com/ext/common/iQIYI/QIYImedia_4_01.exe",
                                fileHttpResponseHandler);
            }

            private void stopCom() {
                // TODO Auto-generated method stub
                fileHttpResponseHandler.setInterrupt(true);
            }
        };
        startButton.setOnClickListener(onClickListener);
        stopButton.setOnClickListener(onClickListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}