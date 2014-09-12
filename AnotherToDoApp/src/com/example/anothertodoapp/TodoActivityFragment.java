package com.example.anothertodoapp;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import controller.Task;
import controller.task_ListAdapter;

public class TodoActivityFragment extends Fragment implements
		OnItemClickListener {

	// Creating list view based on this StackOverflow page:
	// http://stackoverflow.com/questions/22512833/create-listview-in-fragment-android

	final Context context = getActivity();
	static ArrayList<Task> todoList = new ArrayList<Task>();
	private ListView todoListView;
	private task_ListAdapter tla;
	View v;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// PRNTS OUT THE LIST OF TODOs

		v = inflater.inflate(R.layout.todo_frag, container, false);

		todoListView = (ListView) v.findViewById(R.id.todo_listView);

		final Button add_todoButton = (Button) v.findViewById(R.id.add_Button);

		add_todoButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				add_todo();
			}
		});

		setup_adapter();

		return v;
	}

	public void setup_adapter() {

		// Pump list adapter full of task_entities which contain items of
		// todoList
		tla = new task_ListAdapter(getActivity(), R.layout.todo_frag, todoList);

		// Pump adapter into Listview

		ListView newTodoListView = todoListView;
		todoListView.setAdapter(tla);

		Log.d("onclick", "********* THIS IS SETUP ADAPTER: ");

		newTodoListView
				.setOnItemLongClickListener(new OnItemLongClickListener() {
					public boolean onItemLongClick(AdapterView<?> parent,
							View view, int position, long id) {
						{
							Log.d("onclick", "********* THIS IS A LONG CLICK: ");
							// Task task = todoList.get(position);
							edit_todo(position);
						}
						return true;
					}
				});
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
		View promptsView = li.inflate(R.layout.add_todo_dialog, null);

		final EditText taskName = (EditText) promptsView
				.findViewById(R.id.add_todo_dialog);

		// Create a new AlertDialog
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				getActivity());

		// Link the alertdialog to the XML
		alertDialogBuilder.setView(promptsView);

		// Building the dialog for adding
		alertDialogBuilder

		// Makes the "Create" button
				.setPositiveButton("Create",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub

								String newTaskName_toString = (String) taskName
										.getText().toString();

								if (newTaskName_toString.isEmpty()) {
									add_todo();
								}

								else {
									Task newTask = new Task(Utils.getNewID(),
											"todo", false, newTaskName_toString);
									todoList.add(newTask);
									setup_adapter();
								}
							}
						}).setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								// Do nothing
								dialog.cancel();
							}
						});

		AlertDialog alertDialog = alertDialogBuilder.create();

		alertDialog.show();

	}

	public void edit_todo(final int position) {
		// http://developer.android.com/reference/android/app/AlertDialog.Builder.html#setSingleChoiceItems(java.lang.CharSequence[],
		// int, android.content.DialogInterface.OnClickListener)
		// Edit existing todo with LONG CLICK

		LayoutInflater inflator = LayoutInflater.from(getActivity());

		View editTodo = inflator.inflate(R.layout.edit_todo_dialog, null);

		AlertDialog.Builder editDialog = new AlertDialog.Builder(getActivity());

		editDialog
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						})
				.setNeutralButton("Delete",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								todoList.remove(position);
								setup_adapter();
							}
						})
				.setPositiveButton("Archive",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
							}
						});
		AlertDialog alertDialog = editDialog.create();
		alertDialog.show();

	}

}
