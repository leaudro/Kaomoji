package com.helabs.kaomoji.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.helabs.kaomoji.adapter.EmoticonAdapter;

import java.util.Arrays;
import java.util.List;

public class EmoticonListFragment extends ListFragment {

    private EmoticonAdapter adapter;
    private List<String> emoticons = Arrays.asList(":)",":(", ";)", ":/");

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new EmoticonAdapter(emoticons, getActivity());
        setListAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);
        ListView lv = (ListView) v.findViewById(android.R.id.list);
        lv.setDivider(null);
        return v;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        final Activity activity = getActivity();
        String item = adapter.getItem(position);
        activity.startService(activity.getIntent().<Intent>getParcelableExtra("SEND_MESSAGE").setAction(item));
        activity.finish();
    }

    public void setEmoticons(String[] s) {
        emoticons = Arrays.asList(s);
    }
}