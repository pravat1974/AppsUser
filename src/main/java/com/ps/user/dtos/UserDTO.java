package com.ps.user.dtos;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class UserDTO {

	private Integer id;
	private String userName;
	private String password;
	private BigInteger mobile;
	private String email;
	private String createdBy;
	private String lastUpdatedBy;
	private String currentStatus;

	private String userType;

	

	public UserDTO() {
		super();
	}

	public UserDTO(Integer id, String userName, String password, BigInteger mobile, String email, String createdBy,
			String lastUpdatedBy, String currentStatus, LocalDateTime createdTime, LocalDateTime lastUpdatedTime,
			String userType, Set<String> roles) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.mobile = mobile;
		this.email = email;
		this.createdBy = createdBy;
		this.lastUpdatedBy = lastUpdatedBy;
		this.currentStatus = currentStatus;

		this.userType = userType;
		
	}

	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public BigInteger getMobile() {
		return mobile;
	}

	public void setMobile(BigInteger mobile) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



}
