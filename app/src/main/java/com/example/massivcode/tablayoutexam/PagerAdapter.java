package com.example.massivcode.tablayoutexam;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * ViewPager 에 흔히 사용되는 어댑터 입니다.
 */
public class PagerAdapter extends FragmentPagerAdapter {

    // 각각의 페이지에 뿌려줄 Fragment
    private List<Fragment> mList;

    public PagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        mList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

}
