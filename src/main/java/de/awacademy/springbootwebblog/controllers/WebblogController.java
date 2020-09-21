package de.awacademy.springbootwebblog.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.awacademy.springbootwebblog.dtos.CommentDto;
import de.awacademy.springbootwebblog.dtos.PostDto;
import de.awacademy.springbootwebblog.services.PostService;


@Controller
public class WebblogController {

	@Autowired
	private PostService postService;
	
	
	//@RequestMapping(value = { "/start" }, method = RequestMethod.GET)
	@GetMapping({ "/", "/start" })
	public String showStartpage(Model model) {
		
		// First set title to show on start page.
		String title = "View recent posts";
		model.addAttribute("title", title);
		
		// Read all posts from database using service and underlying repository.
		List<PostDto> posts = postService.readPosts();
		model.addAttribute("posts", posts);
		
		return "startpage";
	}
	
	
	@GetMapping("/newPost")
	public String createPost(Model model) {
		
		PostDto postDto = new PostDto();
		model.addAttribute("newPost", postDto);
		
		return "newpost";
	}
	
	
	@PostMapping("/saveNewPost")
	public String savePost(PostDto newPost) {
		
		postService.createPost(newPost.getTitle(), newPost.getContent(), LocalDateTime.now());
		
		return "redirect:/start";
	}
	
	
	@GetMapping("/newComment")
	public String createComment(Model model, @RequestParam Long postId) {
		
		CommentDto commentDto = new CommentDto();
		commentDto.setPostId(postId);

		model.addAttribute("newComment", commentDto);
		
		return "newcomment";
	}
	
	
	@PostMapping("/saveNewComment")
	public String saveComment(CommentDto newComment) {
		
		// FIXME put post id in to method
		postService.attachComment(newComment);
		
		return "redirect:/start";
	}
	
}
