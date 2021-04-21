package com.tyss.springapp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.springapp.dto.UserDetails;
import com.tyss.springapp.dto.UserResponse;
import com.tyss.springapp.service.AirwaysService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AirwaysController {
@Autowired
private AirwaysService service;

@GetMapping("/getplanedetail")
public ResponseEntity<UserResponse> searchById(int id) {
	UserDetails primary = service.getDetaillByID(id);
	UserResponse response = new UserResponse();
	if (primary != null) {
		response.setError(false);
		response.setMessage("Record fetched successfully");
		response.setData(Arrays.asList(primary));
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	} else {
		response.setError(true);
		response.setMessage("Record not fetched successfully");
		response.setData(null);
		return new ResponseEntity<UserResponse>(response, HttpStatus.BAD_REQUEST);
	}
}

@PostMapping("/addplanedetail")
public ResponseEntity<UserResponse> addDetails(@RequestBody UserDetails info) {
	boolean inserted = service.createDetail(info);
	
	UserResponse response = new UserResponse();
	if (inserted) {
		response.setError(false);
		response.setMessage("Record added successful");
		System.out.println("ADD IF");
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	} else {
		response.setError(true);
		response.setMessage("Record not added successfully");
		System.out.println("ADD ELSE");
		return new ResponseEntity<UserResponse>(response, HttpStatus.BAD_REQUEST);
	}
}

@DeleteMapping("/delete")
public ResponseEntity<UserResponse> deleteById(int id) {
	boolean deleted = service.deleteByID(id);
	UserResponse response = new UserResponse();
	if (deleted) {
		response.setError(false);
		response.setMessage("Record deleted successful");
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);

	} else {
		response.setError(true);
		response.setMessage("Record not deleted");
		return new ResponseEntity<UserResponse>(response, HttpStatus.BAD_REQUEST);
	}
}

@GetMapping("/getallplanedetail")
public ResponseEntity<UserResponse> getallRecord() {
	List<UserDetails> primary = service.getAllDetail();
	UserResponse response = new UserResponse();
	if (primary != null) {
		response.setError(false);
		response.setMessage("Record fetched successful");
		response.setData(primary);
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	} else {
		response.setError(true);
		response.setMessage("Record not fetched successfully");
		response.setData(null);
		return new ResponseEntity<UserResponse>(response, HttpStatus.BAD_REQUEST);
	}
}
}
