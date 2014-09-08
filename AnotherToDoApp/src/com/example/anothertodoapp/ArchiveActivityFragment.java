package com.example.anothertodoapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ArchiveActivityFragment extends Fragment {
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.archive_frag, container, false);

        TextView tv = (TextView) v.findViewById(R.id.tvFragFirst);
        tv.setText(getArguments().getString("msg"));

        return v;
    }

    public static ArchiveActivityFragment newInstance() {

    	ArchiveActivityFragment todo_Activity = new ArchiveActivityFragment();
        Bundle b = new Bundle();
     

        todo_Activity.setArguments(b);

        return todo_Activity;
    }

}
