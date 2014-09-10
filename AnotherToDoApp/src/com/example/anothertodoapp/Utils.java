package com.example.anothertodoapp;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import controller.Task;

public class Utils {

	public static void moveTo(int taskID) {
		// Takes in a taskID, finds the task and switches its group to either "todo" or "archive"
		
		// need to parse text file
		
	}
	
	
	public static void changeStatus(Task todo_task, View v) {
		TextView task_textview = (TextView) v.findViewById(R.id.todo_name);
		
		// CHANGES THE STATE OF THE TASK
		// Used this for the StrikeTrhoguh: http://stackoverflow.com/questions/9786544/creating-a-strikethrough-text-in-android
		
		if (todo_task.getStatus() == false) {
			
			Log.d("onclick", "todo status from list: " + todo_task.getStatus());
			Log.d("onclick", "todo Name from list: " + todo_task.getTaskName());
			
			todo_task.setStatus(true);
			
			
			
			Log.d("onclick", "todo status from list: " + todo_task.getStatus());
			
		} else {
			Log.d("onclick", "todo status from list: " + todo_task.getStatus());
			Log.d("onclick", "todo Name from list: " + todo_task.getTaskName());
			
			todo_task.setStatus(false);
			
			Log.d("onclick", "todo status from list: " + todo_task.getStatus());
		}
		
		changeStateFromStatus(todo_task,v);
		
	}
	
	public static void changeStateFromStatus(Task task, View v) {
		TextView task_textview = (TextView) v.findViewById(R.id.todo_name);
		
		if (task.getStatus() == false) {
			task_textview.setPaintFlags(task_textview.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
		}
		else {
			task_textview.setPaintFlags(task_textview.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
		}
		
	}
	
	public static void save(int taskID) {
		//writes to file, using the task ID?????
		
	}
	
	public ArrayList<Task> readTask() {
		ArrayList<Task> taskList = new ArrayList<Task>();
		
		// read form file and pump into taskList
		
		
		
		return taskList;
	}
	
	
	
}

