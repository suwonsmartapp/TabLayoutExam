package com.example.massivcode.tablayoutexam;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        mViewPager = (ViewPager) findViewById(R.id.pager);

        // 뷰페이져에 담을 3개의 프래그먼트를 생성하여 리스트에 저장
        List<Fragment> list = new ArrayList<>();
        list.add(new Fragment1());
        list.add(new Fragment2());
        list.add(new Fragment3());

        // 뷰페이져에 사용될 어댑터 생성
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), list);

        // 뷰페이져에 어댑터 설정
        mViewPager.setAdapter(adapter);

        mTabLayout = (TabLayout) findViewById(R.id.tabs);

        // 탭 레이아웃도 viewPager 처럼 동적으로 추가해야 합니다.
        mTabLayout.addTab(mTabLayout.newTab().setText("1번 탭"));
        mTabLayout.addTab(mTabLayout.newTab().setText("2번 탭"));
        mTabLayout.addTab(mTabLayout.newTab().setText("3번 탭"));

        // 탭 레이아웃의 탭의 선택과 관련된 리스너
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // 어떤 탭을 선택했을 때, 그 위치로 뷰페이져를 이동
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // 뷰페이져가 움직일 때, 뷰페이져의 위치로 탭을 이동
       mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

    }
}
