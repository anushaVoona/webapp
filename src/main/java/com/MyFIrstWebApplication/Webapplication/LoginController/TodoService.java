package com.MyFIrstWebApplication.Webapplication.LoginController;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private static List<Todo> TodoList = new ArrayList<>();

	public static int todoserviceid = 0;

	static {
		/*
		 * TodoList.add(new Todo(++todoserviceid, "No of nuts", 30, 60, "Anusha"));
		 * TodoList.add(new Todo(++todoserviceid, "No of nuts", 25, 50, "Anusha"));
		 * TodoList.add(new Todo(++todoserviceid, "No of nuts", 40, 80, "Anusha"));
		 * TodoList.add(new Todo(++todoserviceid, "No of nuts", 30, 60, "Anusha"));
		 * 
		 */
	}

	public List<Todo> getTodos(String username) {

		return TodoList.stream().filter(e -> e.getUsername().equals(username)).toList();

	}

	public void setTodos(Todo todo) {
		TodoList.add(todo);
	}

	public void delTodos(int id) {

		Predicate<? super Todo> p = Todo -> Todo.getId() == id;

		TodoList.removeIf(p);

	}

	public Todo findById(int id) {
		return TodoList.get(id - 1);
	}

	public void setTodosInUpdate(Todo todo, int id) {
		TodoList.set(id - 1, todo);
	}

}
