package App.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import App.model.Todo;

@Repository
public interface repository extends JpaRepository<Todo, String> {

	List<Todo> findByEmail(String email);
}
