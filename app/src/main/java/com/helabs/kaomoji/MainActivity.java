package com.helabs.kaomoji;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import com.astuetz.PagerSlidingTabStrip;
import com.helabs.kaomoji.adapter.PagerAdapter;


public class MainActivity extends ActionBarActivity {

    private PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        ViewPager pager = (ViewPager) findViewById(R.id.pager);

        adapter = new PagerAdapter(this, getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);
    }
}
