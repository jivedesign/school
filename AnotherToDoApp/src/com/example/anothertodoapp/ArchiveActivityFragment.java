package com.example.anothertodoapp;

import java.util.ArrayList;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ArchiveActivityFragment extends Fragment {
	
	//Creating list view based on this StackOverflow page:
		// http://stackoverflow.com/questions/22512833/create-listview-in-fragment-android
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.archive_frag, container, false);

        ArrayList<String> todoList = new ArrayList<String>();
        todoList.add("One Todo");
        todoList.add("One Todo");
        todoList.add("One Todo");
        todoList.add("One Todo");
        todoList.add("One Todo");
        todoList.add("One Todo");
        todoList.add("One Todo");
        todoList.add("One Todo");
        todoList.add("One Todo");
        todoList.add("One Todo");
        todoList.add("One Todo");
        todoList.add("One Todo");
        
        // Prints out my array to "todo_ListView"
        ListView todoListView = (ListView)v.findViewById(R.id.archive_listView);
        todoListView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, todoList));
             

        return v;
    }

    public static ArchiveActivityFragment newInstance() {

    	ArchiveActivityFragment todo_Activity = new ArchiveActivityFragment();
        Bundle b = new Bundle();
     

        todo_Activity.setArguments(b);

        return todo_Activity;
    }

}
