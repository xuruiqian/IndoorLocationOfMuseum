package com.minusone.indoorlocationofmuseum.activity.demo;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.minusone.indoorlocationofmuseum.activity.R;
import com.minusone.indoorlocationofmuseum.activity.ActivityBase;
import com.minusone.indoorlocationofmuseum.entity.StudyEntity;
import com.ta.annotation.TAInjectView;
import com.ta.mvc.common.TAIResponseListener;
import com.ta.mvc.common.TARequest;
import com.ta.mvc.common.TAResponse;

import java.util.ArrayList;

public class MvcActivtiy extends ActivityBase {
    @TAInjectView(id = R.id.show_button)
    Button clickButton;
    @TAInjectView(id = R.id.show_return)
    TextView showTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demomvc);

        preActivity=R.string.DemoActivity;
        InitTitleBar();
    }

    @Override
    protected void onAfterOnCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onAfterOnCreate(savedInstanceState);
        setTitle(R.string.thinkandroid_mvc_title);

    }

    @Override
    protected void onAfterSetContentView() {
        // TODO Auto-generated method stub
        super.onAfterSetContentView();
        clickButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String strJson = "{\"students\":[{\"name\":\"Jack\",\"age\":12}, {\"name\":\"Vista\",\"age\":23}, {\"name\":\"Kaka\",\"age\":22}, {\"name\":\"Hony\",\"age\":31}]}";
                TARequest request = new TARequest();
                request.setData(strJson);
                doCommand(R.string.testmvccommand, request,
                        new TAIResponseListener() {

                            @Override
                            public void onStart() {
                                // TODO Auto-generated method stub
                                showTextView.setText("onStart");
                            }

                            @Override
                            public void onSuccess(TAResponse response) {
                                // TODO Auto-generated method stub

                                String tempString = "";
                                ArrayList<StudyEntity> arrayList = (ArrayList<StudyEntity>) response
                                        .getData();
                                for (int i = 0; i < arrayList.size(); i++) {
                                    StudyEntity studyEntity = arrayList.get(i);
                                    tempString = tempString
                                            + studyEntity.toString();
                                }
                                showTextView.setText(tempString);
                            }

                            @Override
                            public void onRuning(TAResponse response) {
                                // TODO Auto-generated method stub

                            }

                            @Override
                            public void onFailure(TAResponse response) {
                                // TODO Auto-generated method stub

                            }

                            @Override
                            public void onFinish() {
                                // TODO Auto-generated method stub

                            }

                        }, false);

            }
        });
    }
}