package org.createtogether.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Volunteers")
public class Volunteer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vId;
	
	private String vName;
	
	private String vMobileNo;
	
	private String vEmailId;
	
	private String vAddress;

	public int getvId() {
		return vId;
	}

	public void setvId(int vId) {
		this.vId = vId;
	}

	public String getvName() {
		return vName;
	}

	public void setvName(String vName) {
		this.vName = vName;
	}

	public String getvMobileNo() {
		return vMobileNo;
	}

	public void setvMobileNo(String vMobileNo) {
		this.vMobileNo = vMobileNo;
	}

	public String getvEmailId() {
		return vEmailId;
	}

	public void setvEmailId(String vEmailId) {
		this.vEmailId = vEmailId;
	}

	public String getvAddress() {
		return vAddress;
	}

	public void setvAddress(String vAddress) {
		this.vAddress = vAddress;
	}
	
}
