package com.example.anothertodoapp;

import java.util.ArrayList;

import controller.Task;
import controller.task_ListAdapter;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class TodoActivityFragment extends Fragment {
	
	//Creating list view based on this StackOverflow page:
	// http://stackoverflow.com/questions/22512833/create-listview-in-fragment-android
		
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
		
		// PRNTS OUT THE LIST OF TODOs
		
		View v = inflater.inflate(R.layout.todo_frag, container, false);
		
		ArrayList<Task> todoList = new ArrayList<Task>();
		
		// taskItem = SOME METHOD TO POPULATE TODOLIST
		
		Task task1 = new Task(1,"todo", false, "Todo One"); 
		todoList.add(task1);
		Task task2 = new Task(1,"todo", false, "Todo One"); 
		todoList.add(task2);
		Task task3 = new Task(1,"todo", false, "Todo One"); 
		todoList.add(task3);
		Task task4 = new Task(1,"todo", false, "Todo One"); 
		todoList.add(task4);
		Task task5 = new Task(1,"todo", false, "Todo One"); 
		todoList.add(task5);
		
		// Pump listadapter full of task_entities which contain items of todoList		
		task_ListAdapter tla = new task_ListAdapter(getActivity(), R.layout.task_entity, todoList);
				
        // Prints out my array to "todo_ListView"
		ListView todoListView = (ListView) v.findViewById(R.id.view_todoList);
		
		//Pump adapter into Listview
        todoListView.setAdapter(tla);

        return v;
    }

	
    public static TodoActivityFragment newInstance() {

    	TodoActivityFragment todo_Activity = new TodoActivityFragment();
        Bundle b = new Bundle();
        todo_Activity.setArguments(b);
        
       

        return todo_Activity;
    }
    
   
    
    
    

}
