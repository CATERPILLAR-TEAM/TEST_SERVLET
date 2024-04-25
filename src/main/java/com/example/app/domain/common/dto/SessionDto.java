package com.example.app.domain.common.dto;

public class SessionDto {
	private int session_id;
	private int member_id;

	public SessionDto() {
		super();
	}

	public SessionDto(int session_id, int member_id) {
		super();
		this.session_id = session_id;
		this.member_id = member_id;
	}

	public int getSession_id() {
		return session_id;
	}

	public void setSession_id(int session_id) {
		this.session_id = session_id;
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	@Override
	public String toString() {
		return "SessionDto [session_id=" + session_id + ", member_id=" + member_id + "]";
	}

}
