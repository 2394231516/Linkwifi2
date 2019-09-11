package com.example.a2394231516.linkwifi2.ui;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a2394231516.linkwifi2.R;
import com.example.a2394231516.linkwifi2.fragment.eighteenFragment;
import com.example.a2394231516.linkwifi2.fragment.eighthFragment;
import com.example.a2394231516.linkwifi2.fragment.elevenFragment;
import com.example.a2394231516.linkwifi2.fragment.fifteenFragment;
import com.example.a2394231516.linkwifi2.fragment.fifthFragment;
import com.example.a2394231516.linkwifi2.fragment.firstFragment;
import com.example.a2394231516.linkwifi2.fragment.fourteenFragment;
import com.example.a2394231516.linkwifi2.fragment.fourthFragment;
import com.example.a2394231516.linkwifi2.fragment.ninthFragment;
import com.example.a2394231516.linkwifi2.fragment.secondFragment;
import com.example.a2394231516.linkwifi2.fragment.seventeenFragment;
import com.example.a2394231516.linkwifi2.fragment.seventhFragment;
import com.example.a2394231516.linkwifi2.fragment.sixteenFragment;
import com.example.a2394231516.linkwifi2.fragment.sixthFragment;
import com.example.a2394231516.linkwifi2.fragment.tenFragment;
import com.example.a2394231516.linkwifi2.fragment.thirdFragment;
import com.example.a2394231516.linkwifi2.fragment.thirteenFragment;
import com.example.a2394231516.linkwifi2.fragment.twelveFragment;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutActivity extends AppCompatActivity {

    private ScrollViewPager mViewPager;


    private WifiManager mWifiManager;
    private Spinner pager;
    private List<Fragment> fragments;
    private TextView name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout2);
        initView();
        initData();

    }

    private void initView() {
        mViewPager = findViewById(R.id.viewpager);
        name = findViewById(R.id.name);
    }

    private void initData() {
        mWifiManager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if(!mWifiManager.isWifiEnabled()){
            mWifiManager.setWifiEnabled(true);
        }
        Toast.makeText(this, "请连接到设备的热点", Toast.LENGTH_SHORT).show();


        fragments = new ArrayList<>();
        fragments.add(new firstFragment());
        fragments.add(new secondFragment());
        fragments.add(new thirdFragment());
        fragments.add(new fourthFragment());
        fragments.add(new fifthFragment());
        fragments.add(new sixthFragment());
        fragments.add(new seventhFragment());
        fragments.add(new eighthFragment());
        fragments.add(new ninthFragment());
        fragments.add(new tenFragment());
        fragments.add(new elevenFragment());
        fragments.add(new twelveFragment());
        fragments.add(new thirteenFragment());
        fragments.add(new fourteenFragment());
        fragments.add(new fifteenFragment());
        fragments.add(new sixteenFragment());
        fragments.add(new seventeenFragment());
        fragments.add(new eighteenFragment());

        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        pager = findViewById(R.id.pager);
        pager.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        mViewPager.setCurrentItem(0);
                        name.setText("模块:"+pager.getSelectedItem().toString().trim());
                        break;
                    case 1:
                        mViewPager.setCurrentItem(1);
                        name.setText("模块:"+pager.getSelectedItem().toString().trim());
                        break;
                    case 2:
                        mViewPager.setCurrentItem(2);
                        name.setText("模块:"+pager.getSelectedItem().toString().trim());
                        break;
                    case 3:
                        mViewPager.setCurrentItem(3);
                        name.setText("模块:"+pager.getSelectedItem().toString().trim());
                        break;
                    case 4:
                        mViewPager.setCurrentItem(4);
                        name.setText("模块:"+pager.getSelectedItem().toString().trim());
                        break;
                    case 5:
                        mViewPager.setCurrentItem(5);
                        name.setText("模块:"+pager.getSelectedItem().toString().trim());
                        break;
                    case 6:
                        mViewPager.setCurrentItem(6);
                        name.setText("模块:"+pager.getSelectedItem().toString().trim());
                        break;
                    case 7:
                        mViewPager.setCurrentItem(7);
                        name.setText("模块:"+pager.getSelectedItem().toString().trim());
                        break;
                    case 8:
                        mViewPager.setCurrentItem(8);
                        name.setText("模块:"+pager.getSelectedItem().toString().trim());
                        break;
                    case 9:
                        mViewPager.setCurrentItem(9);
                        name.setText("模块:"+pager.getSelectedItem().toString().trim());
                        break;
                    case 10:
                        mViewPager.setCurrentItem(10);
                        name.setText("模块:"+pager.getSelectedItem().toString().trim());
                        break;
                    case 11:
                        mViewPager.setCurrentItem(11);
                        name.setText("模块:"+pager.getSelectedItem().toString().trim());
                        break;
                    case 12:
                        mViewPager.setCurrentItem(12);
                        name.setText("模块:"+pager.getSelectedItem().toString().trim());
                        break;
                    case 13:
                        mViewPager.setCurrentItem(13);
                        name.setText("模块:"+pager.getSelectedItem().toString().trim());
                        break;
                    case 14:
                        mViewPager.setCurrentItem(14);
                        name.setText("模块:"+pager.getSelectedItem().toString().trim());
                        break;
                    case 15:
                        mViewPager.setCurrentItem(15);
                        name.setText("模块:"+pager.getSelectedItem().toString().trim());
                        break;
                    case 16:
                        mViewPager.setCurrentItem(16);
                        name.setText("模块:"+pager.getSelectedItem().toString().trim());
                        break;
                    case 17:
                        mViewPager.setCurrentItem(17);
                        name.setText("模块:"+pager.getSelectedItem().toString().trim());
                        break;

                    default:
                        mViewPager.setCurrentItem(0);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }



    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }


        @Override
        public int getCount() {
            return fragments.size();
        }


    }
}
