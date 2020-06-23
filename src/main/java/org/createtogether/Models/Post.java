package org.createtogether.Models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	
	private String postTitle;
	
	private String postMetaTitle;
	
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	private String postSummary;
	
	private Boolean postPublished;
	
	@CreationTimestamp
	private LocalDateTime postCreatedDate;
	
	@UpdateTimestamp
	private LocalDateTime postUpdatedDate;
	
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	private String postContent;
	
	@ManyToOne
	private User postUser;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Category category;
	
	@OneToMany(mappedBy = "post")
	private Set<ImageStorage> images = new HashSet<ImageStorage>();
	
	public Post() {
		// TODO Auto-generated constructor stub
	}

	public Post(String postTitle, String postMetaTitle, String postSummary, Boolean postPublished,
			String postContent, User postUser) {
		super();
		this.postTitle = postTitle;
		this.postMetaTitle = postMetaTitle;
		this.postSummary = postSummary;
		this.postPublished = postPublished;
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

	public LocalDateTime getPostCreatedDate() {
		return postCreatedDate;
	}

	public void setPostCreatedDate(LocalDateTime postCreatedDate) {
		this.postCreatedDate = postCreatedDate;
	}

	public LocalDateTime getPostUpdatedDate() {
		return postUpdatedDate;
	}

	public void setPostUpdatedDate(LocalDateTime postUpdatedDate) {
		this.postUpdatedDate = postUpdatedDate;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	@JsonBackReference
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

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postTitle=" + postTitle + ", postMetaTitle=" + postMetaTitle
				+ ", postSummary=" + postSummary + ", postPublished=" + postPublished + ", postCreatedDate="
				+ postCreatedDate + ", postUpdatedDate=" + postUpdatedDate + ", postContent=" + postContent
				+ ", postUser=" + postUser + ", category=" + category + ", images=" + images + "]";
	}
	
}
