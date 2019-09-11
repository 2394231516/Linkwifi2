package com.example.a2394231516.linkwifi2.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/*
 * 项目名：  Linkwifi2
 * 包名：    com.example.a2394231516.linkwifi2.ui
 * 文件名：  ScrollViewPager
 * 创建者：  LCW
 * 创建时间：2019/8/15 19:51
 * 描述：    TODO
 */
public class ScrollViewPager extends ViewPager {
    public ScrollViewPager(@NonNull Context context) {
        super(context);
    }

    public ScrollViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
