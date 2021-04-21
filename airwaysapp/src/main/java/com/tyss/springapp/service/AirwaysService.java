package com.tyss.springapp.service;

import java.util.List;

import com.tyss.springapp.dto.UserDetails;


public interface AirwaysService {
	public UserDetails getDetaillByID(int id);

	public boolean deleteByID(int id);

	public boolean createDetail(UserDetails info);

	public boolean updateDetail(UserDetails info);

	public List<UserDetails> getAllDetail();
}
