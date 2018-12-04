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

public class IndexHomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.index_fragment_home, container, false);
        Button bt = (Button) view.findViewById(R.id.btn_scan);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Start Scan", Toast.LENGTH_SHORT).show();
            }
        });

        Button btn_demo = (Button) view.findViewById(R.id.btn_demo);
        btn_demo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Start Demo", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();
                intent.setClass(getActivity(), DemoActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
