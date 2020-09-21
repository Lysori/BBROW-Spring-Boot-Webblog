package de.awacademy.springbootwebblog.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.awacademy.springbootwebblog.dtos.CommentDto;
import de.awacademy.springbootwebblog.dtos.PostDto;
import de.awacademy.springbootwebblog.entities.Comment;
import de.awacademy.springbootwebblog.entities.Post;
import de.awacademy.springbootwebblog.repositories.CommentRepository;
import de.awacademy.springbootwebblog.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	
	public Boolean createPost(String title, String text, LocalDateTime date) {
		
		// Post with no comments or ratings, yet.
        Post post = new Post(title, text, date);
        postRepository.save(post);
        
		return Boolean.TRUE;
	}

	
	public List<PostDto> readPosts() {
		
		List<Post> allPosts = postRepository.findAll();
		
		List<PostDto> postDtos = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

		for(Post post : allPosts) {
			
			// Map the local date and time to a formatted string so it can be read nicely.
			String creationDate = formatter.format(post.getTimestamp());
			
			PostDto dto = new PostDto(post.getTitle(), post.getText(), creationDate);
			dto.setId(post.getId());
			postDtos.add(dto);
		}
		
		return postDtos;
	}
	
	
	public void attachComment(CommentDto commentDto) {
		
		Comment comment = new Comment(commentDto.getText(), commentDto.getAuthor());
		commentRepository.save(comment);
		
		Optional<Post> postOptional = postRepository.findById(commentDto.getPostId());
		Post post = postOptional.get(); 
		post.getComments().add(comment);
		postRepository.save(post);
	}
	
}
