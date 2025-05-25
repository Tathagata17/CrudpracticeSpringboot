package App.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Todo {

	@Id
	private String id;
	private String taskName;
	private String taskdetail;
	private String taskstatus;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskdetail() {
		return taskdetail;
	}
	public void setTaskdetail(String taskdetail) {
		this.taskdetail = taskdetail;
	}
	public String getTaskstatus() {
		return taskstatus;
	}
	public void setTaskstatus(String taskstatus) {
		this.taskstatus = taskstatus;
	}
	
	
	
	
	
}
