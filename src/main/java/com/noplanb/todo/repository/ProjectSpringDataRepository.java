package com.noplanb.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.noplanb.todo.entity.Project;

public interface ProjectSpringDataRepository extends JpaRepository<Project, Long> {
	List<Project> findByName (String name);
	
	@Query ("select p from Project p join fetch p.tasks where p.id = ?1")
	public Project findTasksByProjectId (Long id);
	
	// named query
	public Project findWithTasks(Long id);
	

}
