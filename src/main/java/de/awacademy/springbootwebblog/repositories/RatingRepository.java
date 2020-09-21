package de.awacademy.springbootwebblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.awacademy.springbootwebblog.entities.Rating;


@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

}
