package com.dao;

public interface LoginDao {
	
	public Long login(String email, String password);
	public String UserDetails(Long id);
}
