package App.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import App.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {

    Users findByEmail(String email); // This will automatically generate the query
}
