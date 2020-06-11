package org.createtogether.Models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ctgId;
	
	@Enumerated(EnumType.STRING)
	private ECategory ctgTitle;
	
	public Category() {
		// TODO Auto-generated constructor stub
	}
	
	public Category(ECategory ctgTitle) {
		super();
		this.ctgTitle = ctgTitle;
	}

	public int getCtgId() {
		return ctgId;
	}

	public void setCtgId(int ctgId) {
		this.ctgId = ctgId;
	}

	public ECategory getCtgTitle() {
		return ctgTitle;
	}

	public void setCtgTitle(ECategory ctgTitle) {
		this.ctgTitle = ctgTitle;
	}
	
}
