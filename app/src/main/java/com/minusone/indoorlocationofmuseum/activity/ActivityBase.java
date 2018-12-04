package com.minusone.indoorlocationofmuseum.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.minusone.indoorlocationofmuseum.usercontrol.TitleBar;
import com.ta.TAActivity;
import com.ta.util.netstate.TANetWorkUtil.netType;

public class ActivityBase extends TAActivity {

    public int getPreActivity() {
        return preActivity;
    }

    public void setPreActivity(int preActivity) {
        this.preActivity = preActivity;
    }

    public int preActivity;

    @Override
    protected void onPreOnCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onPreOnCreate(savedInstanceState);
    }

    @Override
    public void onConnect(netType type) {
        // TODO Auto-generated method stub
        super.onConnect(type);
        Toast.makeText(this, "网络连接开启", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDisConnect() {
        // TODO Auto-generated method stub
        super.onDisConnect();
        Toast.makeText(this, "网络连接关闭", Toast.LENGTH_LONG).show();
    }

    public ImageView mCollectView;
    public boolean mIsSelected;

    public void InitTitleBar() {
        boolean isImmersive = false;
        if (hasKitKat() && !hasLollipop()) {
            isImmersive = true;
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            // getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        } else if (hasLollipop()) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    //| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            isImmersive = true;
        }

        final TitleBar titleBar = (TitleBar) findViewById(R.id.title_bar);

        titleBar.setImmersive(isImmersive);
        titleBar.setBackgroundColor(Color.parseColor("#64b4ff"));
        titleBar.setLeftImageResource(R.mipmap.back_green);
        titleBar.setLeftText("返回");
        titleBar.setLeftTextColor(Color.WHITE);

        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backPreActivity();
            }
        });

        titleBar.setTitle("文章详情");
        titleBar.setTitleColor(Color.WHITE);
        titleBar.setSubTitleColor(Color.WHITE);
        titleBar.setDividerColor(Color.GRAY);
        titleBar.setActionTextColor(Color.WHITE);

        mCollectView = (ImageView) titleBar.addAction(new TitleBar.ImageAction(R.mipmap.collect) {
            @Override
            public void performAction(View view) {
                Toast.makeText(ActivityBase.this, "点击了收藏", Toast.LENGTH_SHORT).show();
                mCollectView.setImageResource(R.mipmap.fabu);
                titleBar.setTitle(mIsSelected ? "文章详情" : "帖子详情");
                mIsSelected = !mIsSelected;
            }
        });

        titleBar.addAction(new TitleBar.TextAction("发布") {
            @Override
            public void performAction(View view) {
                Toast.makeText(ActivityBase.this, "点击了发布", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static boolean hasKitKat() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    }

    public static boolean hasLollipop() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

    public void backPreActivity() {
        back();
        //doActivity(preActivity);
    }
}
