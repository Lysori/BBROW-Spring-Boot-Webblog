package de.awacademy.springbootwebblog;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import de.awacademy.springbootwebblog.dtos.PostDto;
import de.awacademy.springbootwebblog.entities.Comment;
import de.awacademy.springbootwebblog.entities.Post;
import de.awacademy.springbootwebblog.entities.Rating;
import de.awacademy.springbootwebblog.entities.User;
import de.awacademy.springbootwebblog.repositories.CommentRepository;
import de.awacademy.springbootwebblog.repositories.PostRepository;
import de.awacademy.springbootwebblog.repositories.RatingRepository;
import de.awacademy.springbootwebblog.repositories.UserRepository;
import de.awacademy.springbootwebblog.services.PostService;


@SpringBootApplication
public class SpringBootWebblogApplication extends SpringBootServletInitializer {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RatingRepository ratingRepository;
	
	@Autowired
	private PostService postService;
	
	
	/**
	 * Spring Boot's entry point.
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebblogApplication.class, args);
	}

	
	@PostConstruct
	public void initPostWithCommentAndRating() {
	
		postService.createPost("Headline", "Init Post With Comment And Rating", LocalDateTime.now());
		
		
		List<PostDto> readPosts = postService.readPosts();
		for(PostDto postDto : readPosts) {
			System.out.println(postDto);
		}
		
		/*
        // Add a comment to post.
        Comment comment = new Comment("Comment is also splendid.", "Oli");
        commentRepository.save(comment);
        post.getComments().add(comment);
        
        // Now, create a user and rating and put it into post.
        User author = new User();
        author.setEmail("emil@example.com");
        author.setName("Emil");
        userRepository.save(author);
        
        Rating rating = new Rating();
        rating.setAuthor(author);
        rating.setGrade((byte) 3);
        ratingRepository.save(rating);
        
        post.getRatings().add(rating);

        // Save the comments and ratings to the post.
        postRepository.save(post);
        */
	}
	
	
}
