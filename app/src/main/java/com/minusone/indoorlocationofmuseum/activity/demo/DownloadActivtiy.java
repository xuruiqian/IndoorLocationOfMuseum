package com.minusone.indoorlocationofmuseum.activity.demo;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.minusone.indoorlocationofmuseum.activity.ActivityBase;
import com.minusone.indoorlocationofmuseum.activity.R;
import com.ta.TAActivity;
import com.ta.annotation.TAInjectView;

public class DownloadActivtiy extends ActivityBase
{
	@TAInjectView(id = R.id.test_simple_down)
	Button testSimpleDownButton;
	@TAInjectView(id = R.id.test_simple_down_two)
	Button testSimpleTwoDownButton;
	@TAInjectView(id = R.id.test_multi_thread_down)
	Button testMultiThreadDownButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demodownload);

		preActivity=R.string.DemoActivity;
		InitTitleBar();
	}

	@Override
	protected void onAfterOnCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onAfterOnCreate(savedInstanceState);
		setTitle(R.string.thinkandroid_download_title);
	}

	@Override
	protected void onAfterSetContentView()
	{
		// TODO Auto-generated method stub
		super.onAfterSetContentView();
		OnClickListener onClickListener = new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				switch (v.getId())
				{
				case R.id.test_simple_down:
					doActivity(R.string.DownloadSimpleActivtiy);
					break;
				case R.id.test_simple_down_two:
					doActivity(R.string.DownloadSimpleTwoActivtiy);
					break;
				case R.id.test_multi_thread_down:
					doActivity(R.string.DownloadMultiThreadActivtiy);
					break;
				default:
					break;
				}
			}
		};
		testSimpleDownButton.setOnClickListener(onClickListener);
		testSimpleTwoDownButton.setOnClickListener(onClickListener);
		testMultiThreadDownButton.setOnClickListener(onClickListener);
	}

	@Override
	protected void onDestroy()
	{

		super.onDestroy(); // 注意先后
	}
}