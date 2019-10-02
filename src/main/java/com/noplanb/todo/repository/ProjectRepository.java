package com.noplanb.todo.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.noplanb.todo.entity.Project;
import com.noplanb.todo.entity.Task;

@Repository
@Transactional
public class ProjectRepository {

	@Autowired
	private EntityManager em;
		
	public Project findById(Long id) {
		return em.find(Project.class, id);
	}
	
	public void deleteById(Long id) {
		Project project = em.find(Project.class, id);
		em.remove(project);
	}
	
	public Project save(Project project) {
		if (project.getId()==null) {
			em.persist(project);
		} else {
			em.merge(project);
		}
		return project;
	}
	
	public void addTaskToProject (Long projectId, Task task) {
		Project project = findById(projectId);
		project.addTask(task);
		task.setProject(project);
		em.persist(task);
	}
		
}
