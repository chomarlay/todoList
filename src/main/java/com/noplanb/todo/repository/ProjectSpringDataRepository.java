package com.noplanb.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noplanb.todo.entity.Project;

public interface ProjectSpringDataRepository extends JpaRepository<Project, Long> {
	List<Project> findByName (String name);

}
