package com.noplanb.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noplanb.todo.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	List<Task> findByName (String name);

}
