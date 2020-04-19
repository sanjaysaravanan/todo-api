package com.example.demo.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ToDoHardCodedService {
	
	private static List<ToDo> toDos = new ArrayList<>();
	private static int idCounter = 0;
	
	static {
		toDos.add(new ToDo("SanjaySaravanan", "Learn Sprint MVC", new Date(), false ));
	}
	
	public List<ToDo> findAll() {
		return toDos;
	}
	
	public ToDo save(ToDo todo) {
		if(todo.getId() == -1 || todo.getId() == 0) {
			todo.setId(++idCounter);
			toDos.add(todo);
		} else {
			deleteByID(todo.getId());
			toDos.add(todo);
		}
		return todo;
	}
	
	public ToDo deleteByID(int id) {
		ToDo todo = findById(id);
		
		if(todo == null) return null;

		if(toDos.remove(todo)) {
			return todo;
		}
		
		return null;
	}

	public ToDo findById(int id) {
		for(ToDo todo: toDos) {
			if(todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
}
