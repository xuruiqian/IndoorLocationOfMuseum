package com.minusone.indoorlocationofmuseum.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.minusone.indoorlocationofmuseum.activity.R;
import com.ta.annotation.TAInjectView;

public class IndexSettingsFragment extends Fragment {
    //@TAInjectView(id = R.id.btn_settings)
    View btn_settings;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.index_fragment_settings, container, false);

        btn_settings = (View) view.findViewById(R.id.btn_settings);
        btn_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "系统设置", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(getActivity(), SettingsActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}