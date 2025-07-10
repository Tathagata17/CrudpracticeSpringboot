package App.service;

import java.util.List;



import org.springframework.stereotype.Service;

import App.model.Todo;
import App.repository.repository;

@Service
public class service {

	 private final repository repo;

	    public service(repository repo) {
	        this.repo = repo;
	    }
	
	public List getalltodo(String userName)
	{
		return repo.findByEmail(userName);
	}
	public Todo getone(String id)
	{
		return repo.findById(id).orElse(null);
	}
	public void savetodo(Todo todo)
	{
		repo.save(todo);
	}
	public void deleteTodo(String id )
	{
		repo.deleteById(id);
	}
	public void updateTodo(String id )
	{
		
	}
	
	

	
}
