package App.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import App.model.Users;

public interface UserRepository extends JpaRepository<Users, String> {
}
