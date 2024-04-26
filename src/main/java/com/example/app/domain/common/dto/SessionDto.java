package com.example.app.domain.common.dto;

public class SessionDto {
	private String id;
	private String member_id;

	public SessionDto() {
		super();
	}

	public SessionDto(String id, String member_id) {
		super();
		this.id = id;
		this.member_id = member_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	@Override
	public String toString() {
		return "SessionDto [id=" + id + ", member_id=" + member_id + "]";
	}

}
