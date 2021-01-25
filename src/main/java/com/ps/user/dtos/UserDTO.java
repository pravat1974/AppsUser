package com.ps.user.dtos;

import java.math.BigInteger;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDTO {

	private Integer id;
	
	@NotBlank(message="{blank.username}")
	@Size(min = 4,max = 20,message="{size.username}")
	private String userName;
	
	@NotBlank(message="{blank.password}")
	@Size(min = 8,max = 20,message="{size.password}")
	private String password;
	
	@NotNull(message="{size.mobile}")
	private BigInteger mobile;
	
	@NotBlank(message="{blank.email}")
	@Size(min = 8,max = 200,message="{size.email}")
	@Email(regexp = "^[A-Za-z0-9+_.-]+@(.+)$",message="{valid.email}")
	private String email;

	private String createdBy;
	private String lastUpdatedBy;
	private String currentStatus;

	private String userType;

	

	public UserDTO() {
		super();
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


	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", userName=" + userName + ", password=" + password + ", mobile=" + mobile
				+ ", email=" + email + ", createdBy=" + createdBy + ", lastUpdatedBy=" + lastUpdatedBy
				+ ", currentStatus=" + currentStatus + ", userType=" + userType + "]";
	}



}
