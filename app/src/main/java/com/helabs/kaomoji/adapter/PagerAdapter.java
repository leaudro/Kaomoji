package com.helabs.kaomoji.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.helabs.kaomoji.R;
import com.helabs.kaomoji.fragment.EmoticonListFragment;

import java.util.List;

/**
 * Created by hemobile on 17/04/15.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    private final Context context;
    private final String[] titulos;
    private List emoticonList;

    public PagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        titulos = context.getResources().getStringArray(R.array.titulos);
    }

    @Override
    public Fragment getItem(int i) {
        EmoticonListFragment fragment = new EmoticonListFragment();
        fragment.setEmoticons(getEmoticons(i));
        return fragment;
    }

    private String[] getEmoticons(int position) {
        switch (position) {
            case 0:
                return context.getResources().getStringArray(R.array.emoticons0);
            case 1:
                return context.getResources().getStringArray(R.array.emoticons1);
            case 2:
                return context.getResources().getStringArray(R.array.emoticons2);
        }
        return null;
    }

    @Override
    public int getCount() {
        return titulos.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titulos[position];
    }
}