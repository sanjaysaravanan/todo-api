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
		toDos.add(new ToDo(++idCounter, "SanjaySaravanan", "Learn Sprint MVC", new Date(), false ));
		toDos.add(new ToDo(++idCounter, "SanjaySaravanan", "Learn Kubernetes", new Date(), false ));
		toDos.add(new ToDo(++idCounter, "SanjaySaravanan", "Visit Austin Texas", new Date(), false ));
	}
	
	public List<ToDo> findAll() {
		return toDos;
	}
	
	public ToDo deleteByID(long id) {
		ToDo todo = findById(id);
		
		if(todo == null) return null;

		if(toDos.remove(todo)) {
			return todo;
		}
		
		return null;
	}

	private ToDo findById(long id) {
		for(ToDo todo: toDos) {
			if(todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
}
