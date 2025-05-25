package App.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import App.model.Todo;

public interface repository extends JpaRepository<Todo, String> {

}
