package de.awacademy.springbootwebblog.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.awacademy.springbootwebblog.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	// Example query coming from Spring Repository rules.
	Optional<User> findByEmail(String email);
	
}
