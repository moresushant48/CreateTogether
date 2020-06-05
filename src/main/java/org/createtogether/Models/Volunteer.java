package org.createtogether.Models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Volunteers")
public class Volunteer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vId;
	
	private String vFirstName;
	
	private String vLastName;
	
	private String vMobileNo;
	
	private String vEmailId;
	
	private String vAddress;
	
	@CreationTimestamp
    private LocalDateTime createDateTime;
 
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
    
	public int getvId() {
		return vId;
	}

	public void setvId(int vId) {
		this.vId = vId;
	}

	public String getvFirstName() {
		return vFirstName;
	}

	public void setvFirstName(String vFirstName) {
		this.vFirstName = vFirstName;
	}

	public String getvLastName() {
		return vLastName;
	}

	public void setvLastName(String vLastName) {
		this.vLastName = vLastName;
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

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
}
