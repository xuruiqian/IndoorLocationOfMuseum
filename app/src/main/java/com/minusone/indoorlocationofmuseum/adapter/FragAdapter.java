package com.minusone.indoorlocationofmuseum.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class FragAdapter extends FragmentPagerAdapter {
    Context context;
    List<Fragment> listFragment;

    public FragAdapter(FragmentManager fm, Context context, List<Fragment> listFragment) {
        super(fm);
        this.context = context;
        this.listFragment = listFragment;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment != null ? listFragment.size() : 0;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        listFragment.set(position, fragment);
        return fragment;
    }

    public List<Fragment> getFragments() {
        return listFragment;
    }
}