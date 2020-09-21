package de.awacademy.springbootwebblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.awacademy.springbootwebblog.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
