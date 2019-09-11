package com.example.a2394231516.linkwifi2.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.a2394231516.linkwifi2.R;
import com.example.a2394231516.linkwifi2.SendAsyncTask;

/*
 * 项目名：  Linkwifi2
 * 包名：    com.example.a2394231516.linkwifi2.fragment
 * 文件名：  thirdFragment
 * 创建者：  LCW
 * 创建时间：2019/5/7 14:08
 * 描述：    TODO
 */
public class fifteenFragment extends android.support.v4.app.Fragment implements View.OnClickListener {

    private Button mBtn_off;
    private Button mBtn_on;
    private EditText mEt_end;
    private EditText mEt_start;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.third_fragment,container,false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mBtn_on = view.findViewById(R.id.turn_on);
        mBtn_off = view.findViewById(R.id.turn_off);
        mBtn_on.setOnClickListener(this);
        mBtn_off.setOnClickListener(this);
        mEt_start = view.findViewById(R.id.et_start);
        mEt_end = view.findViewById(R.id.et_end);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.turn_on:
                String on = mEt_start.getText().toString().trim();
                Log.d("tag",on);
                new SendAsyncTask().execute(on);
                break;
            case R.id.turn_off:
                String off = mEt_end.getText().toString().trim();
                Log.d("tag",off);
                new SendAsyncTask().execute(off);
                break;
            default:
                break;
        }
    }
}
