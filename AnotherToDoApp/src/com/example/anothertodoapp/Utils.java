package com.example.anothertodoapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
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
	
	
	public static void save(int taskID) {
		//writes to file, using the task ID?????
		
	}
	
	public ArrayList<Task> readTask() {
		ArrayList<Task> taskList = new ArrayList<Task>();
		
		// read form file and pump into taskList
		
		
		
		return taskList;
	}
	
	
	public static void saveObject(Task task) throws FileNotFoundException, IOException {
		// REFERENCED FROM: http://www.coderzheaven.com/2012/07/25/serialization-android-simple-example/
		// Saves task objects to internal storage
	
		Log.d("onclick", "todo status from list bEFORE: " + task.getTaskName());
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("/anotherToDoApp.bin"))); 
        oos.writeObject(task); // write the class as an 'object'
        oos.flush(); // flush the stream to insure all of the information was written to 'save_object.bin'
        oos.close();// close the stream
		
	}
	
	public static Task readObject(File file) throws OptionalDataException, ClassNotFoundException, IOException {
		// Read task objects to internal storage - returns task object
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Task task = (Task) ois.readObject();
        
        Log.d("onclick", "todo status from list bEFORE: " + task.getTaskName());
        
        return task;
		
	}
	
	
}

