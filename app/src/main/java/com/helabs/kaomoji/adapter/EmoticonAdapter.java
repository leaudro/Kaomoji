package com.helabs.kaomoji.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.helabs.kaomoji.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hemobile on 17/04/15.
 */
public class EmoticonAdapter extends BaseAdapter {


    private List<String> emoticons;
    private Context context;

    public EmoticonAdapter() {
        emoticons = new ArrayList<String>();
    }

    public EmoticonAdapter(List<String> emoticons, Context context) {
        this.emoticons = emoticons;
        this.context = context;
    }

    @Override
    public int getCount() {
        return emoticons.size();
    }

    @Override
    public String getItem(int i) {
        return emoticons.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.textview_emoticon, null);
        }
        final String item = getItem(position);
        ((TextView)convertView).setText(item);
        return convertView;
    }
}
