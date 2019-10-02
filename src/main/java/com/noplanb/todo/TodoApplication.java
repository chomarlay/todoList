package com.noplanb.todo;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.noplanb.todo.entity.Project;
import com.noplanb.todo.entity.Task;
import com.noplanb.todo.repository.ProjectRepository;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {
	
	private static Logger Logger = LoggerFactory.getLogger(TodoApplication.class) ;
	
	@Autowired
	ProjectRepository projectRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@Override
//	@Transactional
	public void run(String... args) throws Exception {
//		Project project = projectRepository.findById(10001L);
//		logger.info("Found - " + project.toString());
//		projectRepository.deleteById(10001L);
//		projectRepository.save(new Project("No PlanB"));
		
//		projectRepository.addTaskToProject(10003L, new Task("Spring JPA persistence"));
//		Project project = projectRepository.findById(10003L);
//		Logger.info("Found - " + project.toString());
//		List<Task> tasks = project.getTasks();
//		
//		for (Task task:tasks) {
//			Logger.info("Task - " + task.getName());
//		}
		
	}
}
