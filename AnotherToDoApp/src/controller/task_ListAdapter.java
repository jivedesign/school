package controller;

import java.util.List;

import android.content.Context;
import android.widget.ArrayAdapter;

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

}
