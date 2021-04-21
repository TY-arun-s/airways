package com.tyss.springapp.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@Entity
@Table(name="register")
@JsonRootName("UserDetails")
public class UserDetails {
@Id
@Column
@JsonProperty
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
@Column
@JsonProperty
private String fname;
@Column
@JsonProperty
private String surname;
@Column
@JsonProperty
private String othername;
@Column
@JsonProperty
private Date Birthdate;
@Column
@JsonProperty
private String Country_of_Residence;
@Column
@JsonProperty
private String Nationality;
@Column
@JsonProperty
private String Email;
@Column
@JsonProperty
private String ConfirmEmail;
@Column
@JsonProperty
private long phone_number;
@Column
@JsonProperty
private String password;
@Column
@JsonProperty
private String confirm_password;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getSurname() {
	return surname;
}
public void setSurname(String surname) {
	this.surname = surname;
}
public String getOthername() {
	return othername;
}
public void setOthername(String othername) {
	this.othername = othername;
}
public Date getBirthdate() {
	return Birthdate;
}
public void setBirthdate(Date birthdate) {
	Birthdate = birthdate;
}
public String getCountry_of_Residence() {
	return Country_of_Residence;
}
public void setCountry_of_Residence(String country_of_Residence) {
	Country_of_Residence = country_of_Residence;
}
public String getNationality() {
	return Nationality;
}
public void setNationality(String nationality) {
	Nationality = nationality;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getConfirmEmail() {
	return ConfirmEmail;
}
public void setConfirmEmail(String confirmEmail) {
	ConfirmEmail = confirmEmail;
}
public long getPhone_number() {
	return phone_number;
}
public void setPhone_number(long phone_number) {
	this.phone_number = phone_number;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getConfirm_password() {
	return confirm_password;
}
public void setConfirm_password(String confirm_password) {
	this.confirm_password = confirm_password;
}


}


