package com.noplanb.todo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.noplanb.todo.TodoApplication;
import com.noplanb.todo.entity.Project;
import com.noplanb.todo.entity.Task;
import com.noplanb.todo.repository.ProjectRepository;

@RunWith(SpringRunner.class)
@SpringBootTest (classes=TodoApplication.class)
public class TodoProjectSpringDataRepositoryTests {
	
	private static Logger Logger = LoggerFactory.getLogger(TodoProjectSpringDataRepositoryTests.class) ;

	@Autowired
	ProjectSpringDataRepository projectRepository;
	
	@Test
	public void findProjectById() {
		Optional<Project> projectOptional = projectRepository.findById(10002L);
		assertTrue(projectOptional.isPresent());
	}
	
	@Test
	public void findProjectByName() {
		List<Project> projects = projectRepository.findByName("Spring JPA");
		assertTrue(!projects.isEmpty());
	}
	

	@Test
	@DirtiesContext
	@Transactional
	public void deleteProjectById() {
		Optional<Project> projectOptional = projectRepository.findById(10002L);
		assertTrue(projectOptional.isPresent());
		Project project = projectOptional.get();
		project.removeAllTasks();
		projectRepository.save(project);
		projectRepository.deleteById(10002L);
		projectOptional = projectRepository.findById(10002L);
		assertFalse(projectOptional.isPresent());
	}

	@Test
	@DirtiesContext
	@Transactional
	public void saveProject() {
		Optional<Project> projectOptional = projectRepository.findById(10002L);
		assertTrue(projectOptional.isPresent());
		Project project = projectOptional.get();
		project.setName("Running 2019");
		projectRepository.save(project);
		projectOptional = projectRepository.findById(10002L);
		assertTrue(projectOptional.isPresent());
		project = projectOptional.get();
		assertEquals("Running 2019", project.getName());
	}
//	
	@Test
	@DirtiesContext
	@Transactional
	public void addTaskToProject() {
		Optional<Project> projectOptional = projectRepository.findById(10002L);
		assertTrue(projectOptional.isPresent());
		Project project = projectOptional.get();
		project.addTask(new Task("Task 3"));
		projectRepository.save(project);
		projectOptional = projectRepository.findById(10002L);
		assertTrue(projectOptional.isPresent());
		project = projectOptional.get();
		List<Task> tasks = project.getTasks();
		int totalTasks = 0;
		for (Task task:tasks) {
			Logger.info("Task - " + task.getName());
			totalTasks++;
		}
		assertEquals(3, totalTasks );
	}
}
