package com.basic.programming.bottomnavigationdemo.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import com.basic.programming.bottomnavigationdemo.R;

public class MessageFragment extends ListFragment {

    private String[] values;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        values = getResources().getStringArray(R.array.messages);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        String listItem = (String) getListAdapter().getItem(position);
        Toast.makeText(getActivity(), listItem, Toast.LENGTH_LONG).show();
    }
}
