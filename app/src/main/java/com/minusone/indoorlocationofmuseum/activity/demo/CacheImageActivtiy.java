package com.minusone.indoorlocationofmuseum.activity.demo;

import android.os.Bundle;
import android.widget.GridView;

import com.minusone.indoorlocationofmuseum.activity.ActivityBase;
import com.minusone.indoorlocationofmuseum.activity.R;
import com.minusone.indoorlocationofmuseum.adapter.ImageAdapter;
import com.ta.annotation.TAInjectView;

public class CacheImageActivtiy extends ActivityBase
{
	@TAInjectView(id = R.id.gridView)
	private GridView gridView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.democacheimage);

		preActivity=R.string.DemoActivity;
		InitTitleBar();
	}

	@Override
	protected void onAfterOnCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onAfterOnCreate(savedInstanceState);
		setTitle(R.string.thinkandroid_image_cache_title);
	}

	@Override
	protected void onAfterSetContentView() {
		// TODO Auto-generated method stub
		super.onAfterSetContentView();

		final ImageAdapter adapter = new ImageAdapter(this, getTAApplication());
		gridView.setAdapter(adapter);
	}
}