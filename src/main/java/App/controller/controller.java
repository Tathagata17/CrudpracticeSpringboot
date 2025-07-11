package App.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import App.model.Todo;
import App.service.service;
import App.utils.JwtService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class controller {

	private final service todoService;
	
	@Autowired
	public  JwtService jwtservice;

	public controller(service todoService) {
		this.todoService = todoService;
	}
	@GetMapping("/health")
	public String healthcheck() {
		return "running";
	}
	@GetMapping("/getalltodo")
	public ResponseEntity<List<Todo>> getall() {
		String userName =SecurityContextHolder.getContext().getAuthentication().getName();
		List<Todo> todo= todoService.getalltodo(userName);
		if(todo!=null)
		{
		return new ResponseEntity<>(todo,HttpStatus.OK); 
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
	}

	@GetMapping("/gettodo/{id}")
	public ResponseEntity<Todo> gettodo(@PathVariable String id) {
		Todo currentTodo=todoService.getone(id);
		
		if(currentTodo!=null)
		{
			return new ResponseEntity<>(currentTodo,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}

	@PostMapping("/createtodo")
	public String createTodo(@RequestBody Todo todo,HttpServletRequest request) {
		String authHeader = request.getHeader("Authorization");
		String token = authHeader.substring(7);
		String userName = jwtservice.extractUsername(token);
		todo.setEmail(userName);
		todoService.savetodo(todo);
		return "done and dusted";
	}

	@DeleteMapping("/deletetodo/{id}")
	public String deletetodo(@PathVariable String id) {
		todoService.deleteTodo(id);
		return "yes deleted";
	}

	@PutMapping("updatetodo/{id}")
	public String updatetodo(@PathVariable String id) {
		return "updated";
	}
	

}
