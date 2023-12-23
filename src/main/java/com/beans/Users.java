package com.beans;

import javax.persistence.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="registered_user")
public class Users {
	@Id
	@Column(name="pk_user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long pk_user_id;

	@Transient
	String confirm_password;
	
	@Transient
	public String getConfirm_password() {
		return confirm_password;
	}
	
	@Transient
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	public Long getPk_user_id() {
		return pk_user_id;
	}
	public void setPk_user_id(Long pk_user_id) {
		this.pk_user_id = pk_user_id;
	}
	@Column(name="email")
	String email;
	
	@Column(name="password")
	String password;
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
