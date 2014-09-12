package com.example.anothertodoapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OptionalDataException;
import java.util.ArrayList;

import controller.Task;
import controller.task_ListAdapter;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.style.StrikethroughSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class TodoActivityFragment extends Fragment implements
		OnItemClickListener {

	// Creating list view based on this StackOverflow page:
	// http://stackoverflow.com/questions/22512833/create-listview-in-fragment-android

	final Context context = getActivity();
	ArrayList<Task> todoList = new ArrayList<Task>();
	ListView todoListView ;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// PRNTS OUT THE LIST OF TODOs

		final View v = inflater.inflate(R.layout.todo_frag, container, false);

		todoListView = (ListView) v
				.findViewById(R.id.todo_listView);
		

		// taskItem = SOME METHOD TO POPULATE TODOLIST

		

//		// save the object
//		try {
//			Utils.saveObject(task1);
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		// Get the Object
//		Task task = null;
//		try {
//			task = (Task) Utils.readObject(new File("/anotherToDoApp.bin"));
//		} catch (OptionalDataException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} // get the serialized object from the sdcard and caste it into the
//			// Person class.
//
//		
		setup_adapter();
		
		final Button add_todoButton = (Button) v.findViewById(R.id.add_Button);

		add_todoButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				add_todo();
			}
		});

		return v;
	}

	public void setup_adapter() {
		
		
		Task task1 = new Task(1, "todo", false, "This is my first todo!");
		todoList.add(task1);
		Task task2 = new Task(1, "todo", true, "Todo One");
		todoList.add(task2);
		Task task3 = new Task(1, "todo", true, "Todo One");
		todoList.add(task3);
		Task task4 = new Task(1, "todo", false, "Todo One");
		todoList.add(task4);
		Task task5 = new Task(1, "todo", false, "Banana");
		todoList.add(task5);

		Task task6 = new Task(1, "todo", false, "Banana");
		todoList.add(task6);
		Task task7 = new Task(1, "todo", false, "Banana");
		todoList.add(task7);
		Task task8 = new Task(1, "todo", false, "Ziss iz my Banana task");
		todoList.add(task8);
		Task task9 = new Task(1, "todo", false, "Banana");
		todoList.add(task9);
		Task task10 = new Task(1, "todo", false, "Banana");
		todoList.add(task10);
		Task task11 = new Task(1, "todo", false, "Banana");
		todoList.add(task11);
		Task task12 = new Task(1, "todo", false, "Banana");
		todoList.add(task12);
		Task task13 = new Task(1, "todo", false, "Banana");
		todoList.add(task13);
		Task task14 = new Task(1, "todo", false, "Banana");
		todoList.add(task14);
		Task task15 = new Task(1, "todo", false, "Banana");
		todoList.add(task15);
		Task task16 = new Task(1, "todo", false, "Banana");
		todoList.add(task16);
		
		
		// Pump listadapter full of task_entities which contain items of
		// todoList
		task_ListAdapter tla = new task_ListAdapter(getActivity(),
				R.layout.todo_frag, todoList);

		// Pump adapter into Listview
		todoListView.setAdapter(tla);
		
	}

	public static TodoActivityFragment newInstance() {

		TodoActivityFragment todo_Activity = new TodoActivityFragment();
		Bundle b = new Bundle();
		todo_Activity.setArguments(b);

		return todo_Activity;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub

	}

	public void add_todo() {

		// WITH HELP FROM JASMINE WOO, a real human

		LayoutInflater li = LayoutInflater.from(getActivity());

		// Get XML file to view
		View promptsView = li.inflate(R.layout.add_course_dialog, null);

		final EditText taskName = (EditText) promptsView
				.findViewById(R.id.coursename_dialog);

		// Create a new AlertDialog
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				getActivity());

		// Link the alertdialog to the XML
		alertDialogBuilder.setView(promptsView);

		// Building the dialog for adding
		alertDialogBuilder
		// Makes the cancel button
				.setCancelable(false)

				// Makes the "Create" button
				.setPositiveButton("Create",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub

								String newTaskName_toString = (String) taskName
										.toString();

								if (newTaskName_toString.isEmpty()) {
									add_todo();
								}

								else {
									Task newTask = new Task(1, "todo", false,
											newTaskName_toString);
									todoList.add(newTask);
									setup_adapter();
								}
							}
						});

		
		
		
		AlertDialog alertDialog = alertDialogBuilder.create();

		alertDialog.show();

	}

}
