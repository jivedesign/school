package controller;

public class Task {

	private String class_name;
	protected int taskID;
	protected String group;
	protected String status;
	protected String taskName;

	public String getClass_name() {
		return getClass_name();
	}


	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	
	public Task(int taskID, String group, String status, String taskName) {
		this.taskID = taskID;
		this.group = group;
		this.status = status;
		this.taskName = taskName; 
		
	}


	public int getTaskID() {
		return taskID;
	}


	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}


	public String getGroup() {
		return group;
	}


	public void setGroup(String group) {
		this.group = group;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getTaskName() {
		return taskName;
	}


	public void setTaskName(String taskName) {
		this.taskName = taskName;
	
	}
	
	
	
	//Serialization???
	
	public static void getTaskInfo (int taskID) {
		// Using taskID, gets the tasks associated group, status, and name, then returns them in a list
		// 
		// needs to access file
		
	}
	
	
}
