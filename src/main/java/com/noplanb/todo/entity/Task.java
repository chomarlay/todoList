package com.noplanb.todo.entity;


import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.noplanb.todo.audit.Auditable;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Task extends Auditable<String> {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@ManyToOne (fetch=FetchType.LAZY)
	@JsonIgnore
	private Project project;

	protected Task() {}

	public Task(String name) {
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


	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}


	
	

}
