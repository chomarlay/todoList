package com.noplanb.todo.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.noplanb.todo.entity.Project;
import com.noplanb.todo.entity.Task;
import com.noplanb.todo.service.TodoService;

@RestController
public class TodoController {

	@Autowired
	TodoService todoService;

	@GetMapping("/projects")
	public List<Project> retrieveAllProjects() {
		return todoService.findAllProjects();
	}

	@GetMapping("/projects/{id}")
	public Project retrieveProject(@PathVariable Long id) {
		return todoService.findProjectById(id);
	}

	@GetMapping("/projects/{id}/tasks")
	public List<Task> retriveAllTasksByProject(@PathVariable Long id) {
		return todoService.findTasksByProjectId(id);
	}

	@PostMapping("/projects")
	public ResponseEntity<Object> createProject(@Valid @RequestBody Project project) {
		Project p = todoService.addProject(project);
		// CREATED
		// /projects/{id}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

}
