package controller;

import java.util.List;

import com.example.anothertodoapp.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class task_ListAdapter extends ArrayAdapter<Task> {

	private int layoutResourceId;
	private Context context;
	private List<controller.Task> list;

	public task_ListAdapter(Context context, int layoutResourceId,List<Task> items) {
		super(context, layoutResourceId, items);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.list = items;
	}
	
	public static class TaskListHolder {
		Task task;
		TextView todo_name;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		LayoutInflater inflater = ((Activity) context).getLayoutInflater();
		row = inflater.inflate(layoutResourceId, parent, false);
		
		TaskListHolder holder = new TaskListHolder();
		holder.task = list.get(position);
		
		holder.todo_name = (TextView)row.findViewById(R.id.todo_name);
		row.setTag(holder);
		
		holder.todo_name.setText(holder.task.getTaskName());
		
		return row;
		
		
	}

}
