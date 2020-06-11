package org.createtogether.Models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	
	private String postTitle;
	
	private String postMetaTitle;
	
	private String postSummary;
	
	private Boolean postPublished;
	
	private String postCreatedDate;
	
	private String postUpdatedDate;
	
	private String postContent;
	
	@ManyToOne
	private User postUser;
	
	@ManyToOne
	private Category category;
	
	@OneToMany(mappedBy = "post")
	private Set<ImageStorage> images = new HashSet<ImageStorage>();
	
	public Post() {
		// TODO Auto-generated constructor stub
	}

	public Post(String postTitle, String postMetaTitle, String postSummary, Boolean postPublished,
			String postCreatedDate, String postUpdatedDate, String postContent, User postUser) {
		super();
		this.postTitle = postTitle;
		this.postMetaTitle = postMetaTitle;
		this.postSummary = postSummary;
		this.postPublished = postPublished;
		this.postCreatedDate = postCreatedDate;
		this.postUpdatedDate = postUpdatedDate;
		this.postContent = postContent;
		this.postUser = postUser;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostMetaTitle() {
		return postMetaTitle;
	}

	public void setPostMetaTitle(String postMetaTitle) {
		this.postMetaTitle = postMetaTitle;
	}

	public String getPostSummary() {
		return postSummary;
	}

	public void setPostSummary(String postSummary) {
		this.postSummary = postSummary;
	}

	public Boolean getPostPublished() {
		return postPublished;
	}

	public void setPostPublished(Boolean postPublished) {
		this.postPublished = postPublished;
	}

	public String getPostCreatedDate() {
		return postCreatedDate;
	}

	public void setPostCreatedDate(String postCreatedDate) {
		this.postCreatedDate = postCreatedDate;
	}

	public String getPostUpdatedDate() {
		return postUpdatedDate;
	}

	public void setPostUpdatedDate(String postUpdatedDate) {
		this.postUpdatedDate = postUpdatedDate;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public User getPostUser() {
		return postUser;
	}

	public void setPostUser(User postUser) {
		this.postUser = postUser;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<ImageStorage> getImages() {
		return images;
	}

	public void setImages(Set<ImageStorage> images) {
		this.images = images;
	}
	
}
