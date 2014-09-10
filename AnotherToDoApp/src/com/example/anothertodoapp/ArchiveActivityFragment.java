package com.example.anothertodoapp;

import java.util.ArrayList;

import controller.Task;
import controller.task_ListAdapter;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ArchiveActivityFragment extends Fragment {

	// Creating list view based on this StackOverflow page:
	// http://stackoverflow.com/questions/22512833/create-listview-in-fragment-android

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.archive_frag, container, false);

		ArrayList<Task> archList = new ArrayList<Task>();

		// taskItem = SOME METHOD TO POPULATE ARCHLIST

		Task task1 = new Task(1, "todo", false, "Arch One");
		archList.add(task1);
		Task task2 = new Task(1, "todo", false, "Arch One");
		archList.add(task2);
		Task task3 = new Task(1, "todo", false, "Ach One");
		archList.add(task3);
		Task task4 = new Task(1, "todo", false, "Todo One");
		archList.add(task4);
		Task task5 = new Task(1, "todo", false, "Todo One");
		archList.add(task5);

		task_ListAdapter tla = new task_ListAdapter(getActivity(),
				R.layout.task_entity, archList);

		// Prints out my array to "todo_ListView"
		ListView archListView = (ListView) v.findViewById(R.id.archive_listView);
		
		archListView.setAdapter(tla);

		return v;
	}

	public static ArchiveActivityFragment newInstance() {

		ArchiveActivityFragment todo_Activity = new ArchiveActivityFragment();
		Bundle b = new Bundle();

		todo_Activity.setArguments(b);

		return todo_Activity;
	}

}
