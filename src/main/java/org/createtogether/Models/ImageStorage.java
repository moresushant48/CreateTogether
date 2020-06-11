package org.createtogether.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class ImageStorage {

	@Id
	@GeneratedValue(generator =  "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String imgId;
	
	private String imgName;
	
	private String imgType;
	
	private byte[] imgFile;
	
	@ManyToOne
	private Post post;
	
	public ImageStorage() {

	}
	
	public ImageStorage(String imgName, String imgType, byte[] imgFile) {
		super();
		this.imgName = imgName;
		this.imgType = imgType;
		this.imgFile = imgFile;
	}

	public String getImgId() {
		return imgId;
	}

	public void setImgId(String imgId) {
		this.imgId = imgId;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getImgType() {
		return imgType;
	}

	public void setImgType(String imgType) {
		this.imgType = imgType;
	}

	public byte[] getImgFile() {
		return imgFile;
	}

	public void setImgFile(byte[] imgFile) {
		this.imgFile = imgFile;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
}
