package com.example.anothertodoapp;

import java.util.ArrayList;

import controller.Task;
import controller.task_ListAdapter;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.style.StrikethroughSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class TodoActivityFragment extends Fragment implements OnItemClickListener {
	
	//Creating list view based on this StackOverflow page:
	// http://stackoverflow.com/questions/22512833/create-listview-in-fragment-android
		
	private static final StrikethroughSpan STRIKE_THROUGH_SPAN = new StrikethroughSpan();
	
	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
		
		// PRNTS OUT THE LIST OF TODOs
		
		final View v = inflater.inflate(R.layout.todo_frag, container, false);
		
		final ArrayList<Task> todoList = new ArrayList<Task>();
		
		// taskItem = SOME METHOD TO POPULATE TODOLIST
		
		Task task1 = new Task(1,"todo", false, "This is my first todo!"); 
		todoList.add(task1);
		Task task2 = new Task(1,"todo", true, "Todo One"); 
		todoList.add(task2);
		Task task3 = new Task(1,"todo", true, "Todo One"); 
		todoList.add(task3);
		Task task4 = new Task(1,"todo", false, "Todo One"); 
		todoList.add(task4);
		Task task5 = new Task(1,"todo", true, "Banana"); 
		todoList.add(task5);
		
		// Pump listadapter full of task_entities which contain items of todoList		
		task_ListAdapter tla = new task_ListAdapter(getActivity(), R.layout.todo_frag, todoList);
				
        // Prints out my array to "todo_ListView"
		final ListView todoListView = (ListView) v.findViewById(R.id.todo_listView);
		
		//Pump adapter into Listview
        todoListView.setAdapter(tla);
        
        
              
        
				
        return v;
    }
	
	
//	public void onCheckboxClicked(View view) {
//	    // Is the view now checked?
//	    boolean checked = ((CheckBox) view).isChecked();
//	}
//	
//	public void setOnCheckedChangeListener (CompoundButton.OnCheckedChangeListener listener)
//	
	
	

	
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
    
   
    
    
    

}
