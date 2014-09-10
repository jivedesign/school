package controller;

import java.util.ArrayList;
import java.util.List;

import com.example.anothertodoapp.R;
import com.example.anothertodoapp.Utils;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class task_ListAdapter extends ArrayAdapter<Task> {

	private int layoutResourceId;
	private Context context;
	// private List<controller.Task> list;

	private ArrayList<Task> taskList;

	public task_ListAdapter(Context context, int layoutResourceId,
			ArrayList<Task> taskList) {
		super(context, layoutResourceId, taskList);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.taskList = new ArrayList<Task>();
		this.taskList.addAll(taskList);
	}

	public static class TaskListHolder {
		Task task;
		CheckBox todo_checkBox;
		TextView todo_name;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		// http://www.mysamplecode.com/2012/07/android-listview-checkbox-example.html

		View row = convertView;
		LayoutInflater inflater = ((Activity) context).getLayoutInflater();
		row = inflater.inflate(layoutResourceId, parent, false);

		// TaskListHolder holder = new TaskListHolder();

		// ViewHolder holder = null;
		// Log.v("ConvertView", String.valueOf(position));
		//
		// if (convertView == null) {
		// LayoutInflater vi = (LayoutInflater)getSystemService(
		// Context.LAYOUT_INFLATER_SERVICE);
		// convertView = vi.inflate(R.layout.country_info, null);

		// holder = new ViewHolder();

		// holder.code = (TextView) convertView.findViewById(R.id.code);
		// holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);

		// TaskListHolder holder = new TaskListHolder();

		TaskListHolder holder = null;
		Log.v("ConvertView", String.valueOf(position));

		
		// if (row == null) {
		LayoutInflater vi = (LayoutInflater) getContext().getSystemService(
				Context.LAYOUT_INFLATER_SERVICE);
		row = vi.inflate(R.layout.task_entity, null);
		//

		holder = new TaskListHolder();

		holder.todo_checkBox = (CheckBox) row.findViewById(R.id.todo_checkBox);
		holder.todo_name = (TextView) row.findViewById(R.id.todo_name);

		row.setTag(holder);

		holder.todo_checkBox.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				CheckBox cb = (CheckBox) v;
				Task task = (Task) cb.getTag();
				// Toast.makeText(getApplicationContext(),
				// "Clicked on Checkbox: " + cb.getText() +
				// " is " + cb.isChecked(),
				// Toast.LENGTH_LONG).show();

				// Utils.changeStateFromStatus(task, v);

				task.setStatus(cb.isChecked());
			}
		});
		// } else {
		// holder = (TaskListHolder) row.getTag();
		//
		// }
		//

		Task task = taskList.get(position);

		holder.todo_checkBox.setChecked(task.getStatus());
		holder.todo_name.setText(task.getTaskName());

		holder.todo_name.setTag(task);

		// OLD STUFF

		// holder.task = list.get(position);
		// holder.todo_name = (CheckBox)row.findViewById(R.id.todo_name);
		// row.setTag(holder);
		//
		// holder.todo_name.setText(holder.task.getTaskName());

		return row;

	}

}
