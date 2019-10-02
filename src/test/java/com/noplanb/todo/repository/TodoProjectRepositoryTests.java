package com.noplanb.todo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

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
public class TodoProjectRepositoryTests {
	
	private static Logger Logger = LoggerFactory.getLogger(TodoProjectRepositoryTests.class) ;

	@Autowired
	ProjectRepository projectRepository;
	
	@Test
	public void findProjectById() {
		Project project = projectRepository.findById(10002L);
		assertEquals("Running",project.getName());
	}
	
	@Test
	@DirtiesContext
	public void deleteProjectById() {
		projectRepository.deleteById(10002L);
		assertNull(projectRepository.findById(10002L));
	}

	@Test
	@DirtiesContext
	public void saveProject() {
		Project project = projectRepository.findById(10002L);
		assertEquals("Running", project.getName());
		project.setName("Running 2019");
		projectRepository.save(project);
		assertEquals("Running 2019", project.getName());
	}
	
	@Test
	@DirtiesContext
	@Transactional
	public void addTaskToProject() {
		projectRepository.addTaskToProject(10003L, new Task("Task 3"));
		Project project = projectRepository.findById(10003L);
		List<Task> tasks = project.getTasks();
		int totalTasks = 0;
		for (Task task:tasks) {
			Logger.info("Task - " + task.getName());
			totalTasks++;
		}
		assertEquals(3, totalTasks );
		
	}
}
