package com.noplanb.todo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noplanb.todo.entity.Project;
import com.noplanb.todo.entity.Task;
import com.noplanb.todo.exception.ProjectNotFoundException;
import com.noplanb.todo.repository.ProjectSpringDataRepository;
import com.noplanb.todo.repository.TaskSpringDataRepository;

@Service
public class TodoService {

	@Autowired
	private ProjectSpringDataRepository projectRepository; 
	
	@Autowired
	private TaskSpringDataRepository taskRepository;
	
	public Project findProjectById (Long projectId) {
		Optional<Project> projectOptional = projectRepository.findById(projectId);
		if (projectOptional.isPresent()) {
			return projectOptional.get();
		} else {
			throw new ProjectNotFoundException("Project with id " + projectId + " is not found.");
		}
	}
	
	public Project addProject(Project project) {
		Project p = projectRepository.save(project);
		return p;
	}
	
	public List<Project> findAllProjects () {
		List<Project> projects = projectRepository.findAll();
		return projects;	
	}
	
	public void deleteProject(Long projectId) {
		
		Project project = findProjectById(projectId);
		if (project != null) {
			projectRepository.delete(project);
		} else {
			throw new ProjectNotFoundException("Project with id " + projectId + " is not found.");
		}
	}
	
	public void updateProject (Project newProject) {
		
		Project project = findProjectById(newProject.getId());
		if (project != null) {
			project.setName(newProject.getName());
			projectRepository.save(project);
		} else {
//			throw new ProjectNotFoundException("Project with id " + projectId + " is not found.");
		}
	}
	public void addTaskToProject (Long projectId, Task task) {
		
		Project project = findProjectById(projectId);
		if (project != null) {
			List<Task> tasks = project.getTasks();
			tasks.add(task);
		}
	}
	
	public List<Task> findTasksByProjectId (Long projectId) {
		Project project =	projectRepository.findWithTasks(projectId);
		List<Task> tasks = new ArrayList<>();
		
		if (project != null) {
			tasks = project.getTasks();
		} else {
			throw new ProjectNotFoundException("Project with id " + projectId + " is not found.");
		}
		return tasks;
	}
	
	public Task findTaskById (Long taskId) {
		Optional<Task> taskOptional = taskRepository.findById(taskId);
		if (taskOptional.isPresent()) {
			return taskOptional.get();
		}
		return null;
	}
	
	public Task updateTask (Task task) {
		
		return null;
	}
	
	public Task completeTask (Long taskId) {
		return null;
	}
	
	public void deleteTask (Long taskId) {
		Task task = findTaskById(taskId);
		if ( task!= null) {
			taskRepository.delete(task);
		}
		
	}
	
	
}
