package de.awacademy.springbootwebblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.awacademy.springbootwebblog.entities.Post;


@Repository // This annotation is optional and there to simplify reading
public interface PostRepository extends JpaRepository<Post, Long> {

}
