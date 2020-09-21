package de.awacademy.springbootwebblog.dtos;


public class PostDto {

	private String title;
	private String content;
	private String creationDate;
	
	private Long id;
	
	
	public PostDto() {
	}
	
	
	public PostDto(String title, String content, String creationDate) {
		super();
		this.title = title;
		this.content = content;
		this.creationDate = creationDate;
	}
	
	
	@Override
	public String toString() {
		return "PostDto [content=" + content + ", creationDate=" + creationDate + "]";
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
