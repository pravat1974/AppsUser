package com.ps.user.model;

import java.math.BigInteger;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.boot.context.properties.bind.DefaultValue;
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
@AllArgsConstructor
@Data
@Builder
@JsonIgnoreProperties({ "lastUpdatedTime", "createdTime", "newUser", "roles" })
public class APPUser implements Persistable<Integer> {

	@Id
	@Column("id")
	private Integer id;
	
	@NotBlank(message="{blank.username}")
	@Size(min = 4,max = 20,message="{size.username}")
	@Column("username")
	private String userName;
	
	@NotBlank(message="{blank.password}")
	@Size(min = 8,max = 20,message="{size.password}")
	private String password;
	
	@NotNull(message="{size.mobile}")
	private BigInteger mobile;
	
	@NotBlank(message="{blank.email}")
	@Size(min = 8,max = 200,message="{size.email}")
	@Email(regexp = "^[A-Za-z0-9+_.-]+@(.+)$",message="{valid.email}" )
	private String email;
	
	@Column("createdBy")
	private String createdBy;
	@Column("lastUpdatedBy")
	private String lastUpdatedBy;
	@Column("currentStatus")
	private String currentStatus;
	@Column("createdTime")
	@NotNull
	private java.time.LocalDateTime createdTime;
	@Column("lastUpdatedTime")
	@NotNull
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
		APPUser other = (APPUser) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	

}
