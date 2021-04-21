package com.tyss.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.springapp.dao.AirwaysDAO;
import com.tyss.springapp.dto.UserDetails;

@Service
public class AirwaysServiceImpl implements AirwaysService {
	@Autowired
	AirwaysDAO dao;
	@Override
	public UserDetails getDetaillByID(int id) {
		// TODO Auto-generated method stub
		return dao.getDetaillByID(id);
	}

	@Override
	public boolean deleteByID(int id) {
		if(id!=0) {
			System.out.println("record deleted");
			return dao.deleteByID(id);
		}
		System.out.println("record not deleted");
		return false;
		}

	@Override
	public boolean createDetail(UserDetails info) {
		// TODO Auto-generated method stub
		return dao.createDetail(info);
	}

	@Override
	public boolean updateDetail(UserDetails info) {
		// TODO Auto-generated method stub
		return dao.updateDetail(info);
	}

	@Override
	public List<UserDetails> getAllDetail() {
		// TODO Auto-generated method stub
		return dao.getAllDetail();
	}

}
