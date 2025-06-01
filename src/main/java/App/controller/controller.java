package App.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import App.dto.password;
import App.model.Todo;
import App.service.service;
import App.utils.PasswordEncrypter;

@RestController
@RequestMapping("/api")
public class controller {

	private final service todoService;

	public controller(service todoService) {
		this.todoService = todoService;
	}
	@GetMapping("/health")
	public String healthcheck() {
		return "running";
	}
	@GetMapping("/getalltodo")
	public List getall() {
		return todoService.getalltodo();
	}

	@GetMapping("/gettodo/{id}")
	public Todo gettodo(@PathVariable String id) {
		return todoService.getone(id);
	}

	@PostMapping("/createtodo")
	public String createTodo(@RequestBody Todo todo) {
		todoService.savetodo(todo);
		return "done";
	}

	@DeleteMapping("/deletetodo/{id}")
	public String deletetodo(@PathVariable String id) {
		todoService.deleteTodo(id);
		return "deleted";
	}

	@PutMapping("updatetodo/{id}")
	public String update(@PathVariable String id) {
		return "updated";
	}
}
