package com.codetest.todo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.GetMapping;

import com.codetest.todo.TodoApplication;
import com.codetest.todo.model.Todo;
import com.codetest.todo.model.TodoRepository;

//@ContextConfiguration(classes=TodoApplication.class)
//@WebMvcTest
@SpringBootTest
public class MainControllerTest {
	
	@Mock
	TodoRepository repositoryTest;
	
	@InjectMocks
	MainController controllerTest;
	
	@Autowired
	private MockMvc mockMvc;
	
	@BeforeEach
	public void beforeTestStarts() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controllerTest).build();	
	}
	
	@Test
	public void testListTodos() {
		List<Todo> todos=new ArrayList<>();
		todos.add(new Todo(200, "test", "Coding", new Date(), false));
		todos.add(new Todo(201, "test", "Testing", new Date(), false));
		when(repositoryTest.findByUser("test")).thenReturn(todos);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/list-todos"))
				.andExpect(view().name("customer/"))
	}
	
	@Test
	public void testAddTodo() {
		
		
	}

}
