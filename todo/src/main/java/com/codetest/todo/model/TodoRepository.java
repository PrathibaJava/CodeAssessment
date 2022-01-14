package com.codetest.todo.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codetest.todo.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

	List<Todo> findByUser(String user);
}
