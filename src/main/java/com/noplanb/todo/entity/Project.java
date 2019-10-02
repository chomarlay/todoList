package com.noplanb.todo.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Project {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@OneToMany (mappedBy= "project")
	private List<Task> tasks = new ArrayList<>();

	protected Project() {}

	public Project(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public List<Task> getTasks() {
		return tasks;
	}

	public void addTask(Task task) {
		this.tasks.add(task);
	}
	
	public void removeTask(Task task) {
		this.tasks.remove(task);
	}

	public void removeAllTasks() {
		this.tasks = new ArrayList<>();
	}
	
	@Override
	public String toString() {
		return "Project [name=" + name + "]";
	}
	
	

}
