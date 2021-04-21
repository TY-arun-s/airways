package com.tyss.springapp.dto;

import java.util.List;

public class UserResponse {
	private boolean error;
	private String message;
	private List<UserDetails> data;
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<UserDetails> getData() {
		return data;
	}
	public void setData(List<UserDetails> data) {
		this.data = data;
	}
	
}



