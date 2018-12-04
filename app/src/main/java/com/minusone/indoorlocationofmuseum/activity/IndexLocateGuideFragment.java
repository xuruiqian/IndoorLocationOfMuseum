package com.minusone.indoorlocationofmuseum.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.minusone.indoorlocationofmuseum.activity.R;

public class IndexLocateGuideFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.index_fragment_locateguide, container, false);

        return view;
    }
}
