package com.helabs.kaomoji.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.helabs.kaomoji.R;
import com.helabs.kaomoji.adapter.EmoticonAdapter;

import java.util.Arrays;
import java.util.List;

public class EmoticonGridFragment extends Fragment implements AdapterView.OnItemClickListener {

    private EmoticonAdapter adapter;
    private List<String> emoticons;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new EmoticonAdapter(emoticons, getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = View.inflate(getActivity(), R.layout.frag_emoticons, null);
        GridView grid = (GridView) v.findViewById(R.id.grid);
        grid.setOnItemClickListener(this);
        grid.setAdapter(adapter);
        return v;
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        final Activity activity = getActivity();
        String item = adapter.getItem(position);
        activity.startService(activity.getIntent().<Intent>getParcelableExtra("SEND_MESSAGE").setAction(item));
        activity.finish();
    }

    public void setEmoticons(String[] s) {
        emoticons = Arrays.asList(s);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}