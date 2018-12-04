package com.minusone.indoorlocationofmuseum.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.minusone.indoorlocationofmuseum.activity.demo.CacheActivtiy;
import com.minusone.indoorlocationofmuseum.activity.demo.CacheImageActivtiy;
import com.minusone.indoorlocationofmuseum.activity.demo.DatabaseActivtiy;
import com.minusone.indoorlocationofmuseum.activity.demo.DownloadActivtiy;
import com.minusone.indoorlocationofmuseum.activity.demo.HttpActivtiy;
import com.minusone.indoorlocationofmuseum.activity.demo.MvcActivtiy;
import com.minusone.indoorlocationofmuseum.activity.demo.OtherActivtiy;
import com.ta.annotation.TAInjectView;
import com.ta.util.db.TASQLiteDatabase;

public class SettingsActivity extends ActivityBase {
    @TAInjectView(id = R.id.btn_exit)
    View btn_exit;

    private TASQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        InitTitleBar();
    }

    @Override
    protected void onAfterOnCreate(Bundle savedInstanceState) {
        super.onAfterOnCreate(savedInstanceState);
    }

    @Override
    protected void onAfterSetContentView() {
        super.onAfterSetContentView();

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SwitchActivityAndView(v);
            }
        };
        btn_exit.setOnClickListener(onClickListener);
    }

    private void SwitchActivityAndView(View v) {
        switch (v.getId()) {
            case R.id.btn_exit: {
                exitApp();
                break;
            }
            default:
                break;
        }
    }
}