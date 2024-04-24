package com.example.app.domain.common.dto;

public class MemberDto {
	private String realname;
	private String birth;
	private int gender;
	private String phone;
	private String email;
	private String username;
	private String password;
	private String confrimPassword;
	
	public MemberDto() {
		super();
	}

	public MemberDto(String realname, String birth, int gender, String phone, String email, String username,
			String password, String confrimPassword) {
		super();
		this.realname = realname;
		this.birth = birth;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.password = password;
		this.confrimPassword = confrimPassword;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int isGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfrimPassword() {
		return confrimPassword;
	}

	public void setConfrimPassword(String confrimPassword) {
		this.confrimPassword = confrimPassword;
	}

	@Override
	public String toString() {
		return "MemberDto [realname=" + realname + ", birth=" + birth + ", gender=" + gender + ", phone=" + phone
				+ ", email=" + email + ", username=" + username + ", password=" + password + ", confrimPassword="
				+ confrimPassword + "]";
	}
	
	
}
