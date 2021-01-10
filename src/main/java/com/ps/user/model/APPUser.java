package com.ps.user.model;

import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Table(value="APPUser")

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@Data
@Builder
public class APPUser implements Persistable<Integer> {

	@Id
	@Column("id")
	private Integer id;
	@Column("userName")
	private String userName;
	@Column("password")
	private String password;
	@Column("mobile")
	private Long mobile;
	@Column("email")
	private String email;
	@Column("createdBy")
	private String createdBy;
	@Column("lastUpdatedBy")
	private String lastUpdatedBy;
	@Column("currentStatus")
	private String currentStatus;
	@Column("createdTime")
	private java.time.LocalDateTime createdTime;
	@Column("lastUpdatedTime")
	private java.time.LocalDateTime lastUpdatedTime;
	@Column("userType")
	private String userType;
	@Transient
	private Set<String> roles;
	
	@Transient
	private boolean newUser;
	
	
	
	public APPUser() {
		super();
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

	public java.time.LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(java.time.LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public java.time.LocalDateTime getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(java.time.LocalDateTime lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}


	  @Override
	   @Transient
	public boolean isNew() {
		  return this.newUser || id == null;
	}
	  public APPUser setAsNew(){
	        this.newUser = true;
	        return this;
	    }

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	

}
