package com.example.a2394231516.linkwifi2.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.a2394231516.linkwifi2.R;
import com.example.a2394231516.linkwifi2.SendAsyncTask;

/*
 * 项目名：  Linkwifi2
 * 包名：    com.example.a2394231516.linkwifi2.fragment
 * 文件名：  secondFragment
 * 创建者：  LCW
 * 创建时间：2019/5/7 14:08
 * 描述：    模块二
 */
public class seventeenFragment extends android.support.v4.app.Fragment implements View.OnClickListener {


    private Button mTurn_off;
    private Button mTurn_on;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment,container,false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mTurn_on = view.findViewById(R.id.turn_on);
        mTurn_off = view.findViewById(R.id.turn_off);
        mTurn_off.setOnClickListener(this);
        mTurn_on.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //启动指令
            case R.id.turn_on:
                String on = "";
                new SendAsyncTask().execute(on);
                break;

            case R.id.turn_off:
                String off = "";
                new SendAsyncTask().execute(off);
                break;

            default:
                break;
        }
    }
}
