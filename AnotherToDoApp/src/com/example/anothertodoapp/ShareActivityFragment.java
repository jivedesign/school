package com.example.anothertodoapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ShareActivityFragment extends Fragment {
	
	//Creating list view based on this StackOverflow page:
		// http://stackoverflow.com/questions/22512833/create-listview-in-fragment-android
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.share_frag, container, false);


        return v;
    }

    public static ShareActivityFragment newInstance() {

    	ShareActivityFragment share_Activity = new ShareActivityFragment();
        Bundle b = new Bundle();
    

        return share_Activity;
    }

}
