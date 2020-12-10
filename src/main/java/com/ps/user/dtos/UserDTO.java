package com.ps.user.dtos;

import java.time.LocalDateTime;
import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class UserDTO {

	private Integer ID;
	private String userName;
	private String password;
	private Long mobile;
	private String email;
	private String createdBy;
	private String lastUpdatedBy;
	private String currentStatus;

	private String userType;

	

	public UserDTO() {
		super();
	}

	public UserDTO(Integer id, String userName, String password, Long mobile, String email, String createdBy,
			String lastUpdatedBy, String currentStatus, LocalDateTime createdTime, LocalDateTime lastUpdatedTime,
			String userType, Set<String> roles) {
		super();
		this.ID = id;
		this.userName = userName;
		this.password = password;
		this.mobile = mobile;
		this.email = email;
		this.createdBy = createdBy;
		this.lastUpdatedBy = lastUpdatedBy;
		this.currentStatus = currentStatus;

		this.userType = userType;
		
	}

	
	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}



}
