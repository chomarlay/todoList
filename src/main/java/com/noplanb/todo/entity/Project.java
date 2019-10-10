package com.noplanb.todo.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NamedQuery;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.noplanb.todo.audit.Auditable;

@Entity
@NamedQuery(name = "Project.findWithTasks", 
	query = "select p from Project p join fetch p.tasks where p.id = :id")

@EntityListeners(AuditingEntityListener.class)
public class Project extends Auditable<String> {
	@Id
	@GeneratedValue
	private Long id;
	
	@Size (min=2, message="Project name must be at least 2 characters")
	private String name;
	
	@OneToMany (mappedBy= "project", fetch = FetchType.LAZY)
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

	
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "Project [name=" + name + "]";
	}
	
	

}
