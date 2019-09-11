package com.example.a2394231516.linkwifi2.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.a2394231516.linkwifi2.R;
import com.example.a2394231516.linkwifi2.SendAsyncTask;

import static com.example.a2394231516.linkwifi2.R.id.statue;

/*
 * 项目名：  Linkwifi2
 * 包名：    com.example.a2394231516.linkwifi2.ui
 * 文件名：  firstFragment
 * 创建者：  LCW
 * 创建时间：2019/5/7 14:07
 * 描述：    TODO
 */
public class seventhFragment extends android.support.v4.app.Fragment implements View.OnClickListener {


    private static final int TURN_ON = 1;
    private static final int TURN_OFF = 2;
    private Button mTurn_on;
    private Button mTurn_off;
    private TextView mStatue;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment,container,false);
        initView(view);
        return view;
    }
    /*
   handler信息处理
    */
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    mStatue.setText("状态：已经发送打开指令7");
                    break;
                case 2:
                    mStatue.setText("状态：已经发送.关闭指令01 05 0FA0 0000 CEFC");
                    break;
                default:
                    break;
            }
        }
    };

    private void initView(View view) {
        mTurn_on = view.findViewById(R.id.turn_on);
        mTurn_off = view.findViewById(R.id.turn_off);
        mStatue = view.findViewById(statue);
        mTurn_on.setOnClickListener(this);
        mTurn_off.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.turn_on:
                String str = "01 05 0FA0 FF00 8F 0C";

                new SendAsyncTask().execute(str);
                Message message = new Message();
                message.what = seventhFragment.TURN_ON;
                handler.sendMessage(message);
                break;
            case R.id.turn_off:
                String str2 = "01 05 0FA0 0000 CEFC";
                new SendAsyncTask().execute(str2);
                Message message2 = new Message();
                message2.what = seventhFragment.TURN_OFF;
                handler.sendMessage(message2);
                break;
            default:
                break;
        }
    }
}
