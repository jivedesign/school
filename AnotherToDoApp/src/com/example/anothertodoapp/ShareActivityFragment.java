package com.example.anothertodoapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ShareActivityFragment extends Fragment {
	
	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.share_frag, container, false);

        TextView tv = (TextView) v.findViewById(R.id.tvFragFirst);
        tv.setText(getArguments().getString("msg"));

        return v;
    }

    public static ShareActivityFragment newInstance() {

    	ShareActivityFragment share_Activity = new ShareActivityFragment();
        Bundle b = new Bundle();
       
        share_Activity.setArguments(b);

        return share_Activity;
    }

}
