package com.smplilearn.sportyshoes.entities;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int UserId;
	private String UnerName;

	private String UserEmail;
	private String UserPassword;
	private String Userphone;
	private String UserPic;
	@Column(length = 1500)
	private String UserAddress;

	private String UserType;

	public User(int userId, String unerName, String userEmail, String userPassword, String userphone, String userPic,
			String userAddress, String userType) {

		this.UserId = userId;
		this.UnerName = unerName;
		this.UserEmail = userEmail;
		this.UserPassword = userPassword;
		this.Userphone = userphone;
		this.UserPic = userPic;
		this.UserType = userType;
		this.UserAddress = userAddress;

	}

	public User(String unerName, String userEmail, String userPassword, String userphone, String userPic,
			String userAddress, String userType) {
		super();
		this.UnerName = unerName;
		this.UserEmail = userEmail;
		this.UserPassword = userPassword;
		this.Userphone = userphone;
		this.UserPic = userPic;

		this.UserAddress = userAddress;
		this.UserType = userType;

	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getUnerName() {
		return UnerName;
	}

	public void setUnerName(String unerName) {
		UnerName = unerName;
	}

	public String getUserEmail() {
		return UserEmail;
	}

	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}

	public String getUserPassword() {
		return UserPassword;
	}

	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}

	public String getUserphone() {
		return Userphone;
	}

	public void setUserphone(String userphone) {
		Userphone = userphone;
	}

	public String getUserPic() {
		return UserPic;
	}

	public void setUserPic(String userPic) {
		UserPic = userPic;
	}

	public String getUserAddress() {
		return UserAddress;
	}

	public void setUserAddress(String userAddress) {
		UserAddress = userAddress;
	}

	public String getUserType() {
		return UserType;
	}

	public void setUserType(String userType) {
		UserType = userType;
	}

	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", UnerName=" + UnerName + ", UserEmail=" + UserEmail + ", UserPassword="
				+ UserPassword + ", Userphone=" + Userphone + ", UserPic=" + UserPic + ", UserAddress=" + UserAddress
				+ "]";
	}

}
