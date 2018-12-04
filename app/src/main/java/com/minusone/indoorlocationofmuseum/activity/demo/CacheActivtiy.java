package com.minusone.indoorlocationofmuseum.activity.demo;

import android.os.Bundle;
import android.widget.ListView;

import com.minusone.indoorlocationofmuseum.activity.ActivityBase;
import com.minusone.indoorlocationofmuseum.activity.R;
import com.minusone.indoorlocationofmuseum.adapter.StringAdapter;
import com.ta.annotation.TAInjectView;

public class CacheActivtiy extends ActivityBase
{
	@TAInjectView(id = R.id.listview)
	ListView listView;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.democache);

		preActivity=R.string.DemoActivity;
		InitTitleBar();
	}

	@Override
	protected void onAfterOnCreate(Bundle savedInstanceState)
	{
		super.onAfterOnCreate(savedInstanceState);
		setTitle(R.string.thinkandroid_cache_title);
	}

	@Override
	protected void onAfterSetContentView() {
		// TODO Auto-generated method stub
		super.onAfterSetContentView();

		StringAdapter adapter = new StringAdapter(this, getTAApplication());
		listView.setAdapter(adapter);
	}
}