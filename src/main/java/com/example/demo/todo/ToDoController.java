package com.example.demo.todo;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.todo.ToDo;
import com.example.demo.todo.ToDoHardCodedService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class ToDoController {
	
	@Autowired
	private ToDoRepository todoService;
	
	//GET - all ToDos
	@GetMapping("/users/{username}/todos")
	@ApiOperation(
			value = "Get all Todos for a user",
			notes = "Provide an username to look up specific todos from the ToDos"
	)
	public List<ToDo> getAllTodos(@PathVariable String username){
		return todoService.findAll();
	}
	
	//GET - single ToDo By Id
	@GetMapping("/users/{username}/todos/{id}")
	@ApiOperation(
			value = "Get info about a particular ToDo",
			notes = "Provide an username and id to look up specific todo from the ToDos"
	)
	public Optional<ToDo> getTodo(@PathVariable String username, @PathVariable int id){
		return todoService.findById(id);
	}
	
	//POST - Create a new ToDo
	@PostMapping("/users/{username}/todos")
	@ApiOperation(
			value = "Create a ToDo for an UserName",
			notes = "Provide an username to create specific todo into ToDos"
	)
	public ResponseEntity<Void> createTodo(
			@PathVariable String username,@RequestBody ToDo todo) {

		ToDo createdTodo = todoService.save(todo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//PUT - Update a single ToDo By Id
	@PutMapping("/users/{username}/todos/{id}")
	@ApiOperation(
			value = "Update a ToDo for an UserName",
			notes = "Provide an username to update specific todo into ToDos"
	)
	public ResponseEntity<ToDo> updateTodo(
		@PathVariable String username,
		@PathVariable long id,
		@RequestBody ToDo todo
	) {
		ToDo todoUpdated = todoService.save(todo);
		return new ResponseEntity<ToDo>(todo, HttpStatus.OK);
	}
	
	// DELETE /users/{username}/todos/{id}
	@DeleteMapping("/users/{username}/todos/{id}")
	@ApiOperation(
			value = "Delete a ToDo for an UserName",
			notes = "Provide an username and id to delete specific todo from ToDos"
	)
	public ResponseEntity<Void> deleteTodo(
			@PathVariable String username, @ApiParam(
					value= "ID value for the todo you need to delete",
					required = true) @PathVariable int id) {
		ToDo todo = todoService.getOne(id);
		if(todo == null) {
			return ResponseEntity.noContent().build();
		}
		
		todoService.delete(todo);
		return ResponseEntity.ok().build();
		
	}
	
}
