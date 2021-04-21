package com.tyss.springapp.dao;

import java.util.List;

import com.tyss.springapp.dto.UserDetails;


public interface AirwaysDAO {
	public UserDetails getDetaillByID(int id);

	public boolean deleteByID(int id);

	public boolean createDetail(UserDetails info);

	public boolean updateDetail(UserDetails info);

	public List<UserDetails> getAllDetail();
}
