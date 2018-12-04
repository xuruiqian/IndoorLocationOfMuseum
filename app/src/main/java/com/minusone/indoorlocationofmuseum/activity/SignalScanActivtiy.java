package com.minusone.indoorlocationofmuseum.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ta.annotation.TAInjectView;
import com.ta.util.db.TASQLiteDatabase;


public class SignalScanActivtiy extends ActivityBase {
    @TAInjectView(id = R.id.btn_scan)
    Button btn_scan;

    private TASQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signalscan);

        preActivity=R.string.IndexActivity;
        InitTitleBar();
    }

    @Override
    protected void onAfterOnCreate(Bundle savedInstanceState) {
        super.onAfterOnCreate(savedInstanceState);
        setTitle(R.string.signal_scan_title);
    }

    @Override
    protected void onAfterSetContentView() {
        // TODO Auto-generated method stub
        super.onAfterSetContentView();
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                switch (v.getId()) {
                    case R.id.btn_scan:
                        btnSignalScan();
                        break;
                    default:
                        break;
                }
            }
        };
        btn_scan.setOnClickListener(onClickListener);
    }

    private void btnSignalScan() {
        Toast.makeText(this, "Start Scan", Toast.LENGTH_LONG).show();
    }
}