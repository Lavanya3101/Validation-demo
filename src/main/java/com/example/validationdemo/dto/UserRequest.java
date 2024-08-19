package com.example.validationdemo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserRequest {
	@NotBlank(message = "name shouldn't ne null")
	private String name;
	@Email
	@NotBlank(message = "email shouldn't ne null")
	private String email;
	@NotNull(message = "mobile no shouldn't ne null")
	@Pattern(regexp = "^\\+?[0-9.()-]{7,25}$",message = "Mobile number is invalid")
	@Size(min = 10,max = 15,message = "mobile no shoul be b/w 10 and 15 characters")
	private String mobile;
	@NotBlank(message = "gender is mandatory")
	private String gender;
	@NotNull(message = "age is mandatory")
//	@Min(value = 0,message = "age shouldn't be less than 0")
	@Min(18)
	@Max(60)
	private int age;
	@NotBlank(message = "Nationality is mandatory")
	private String nationality;
	public UserRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRequest(String name, String email, String mobile, String gender, int age, String nationality) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.age = age;
		this.nationality = nationality;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
}
