package com.example.app.domain.common.dto;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class ReservationDto {
	private int room_info_id;
	private int user_id;

	private boolean reservation_type;
	private LocalDateTime check_in;
	private LocalDateTime check_out;
	
	
	
	public ReservationDto() {
		// TODO Auto-generated constructor stub
	}
	public ReservationDto(Integer room_id, Integer userid, Boolean reservtype, LocalDateTime checkin,
			LocalDateTime checkout) {
		// TODO Auto-generated constructor stub
	}
	// getter setter
	public int getRoom_info_id() {
		return room_info_id;
	}
	public void setRoom_info_id(int room_info_id) {
		this.room_info_id = room_info_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public boolean isReservation_type() {
		return reservation_type;
	}
	public void setReservation_type(boolean reservation_type) {
		this.reservation_type = reservation_type;
	}
	public LocalDateTime getCheck_in() {
		return check_in;
	}
	public void setCheck_in(LocalDateTime check_in) {
		this.check_in = check_in;
	}
	public LocalDateTime getCheck_out() {
		return check_out;
	}
	public void setCheck_out(LocalDateTime check_out) {
		this.check_out = check_out;
	}
	
	// toString
	@Override
	public String toString() {
		return "ReservationDto [room_info_id=" + room_info_id + ", user_id=" + user_id + ", reservation_type="
				+ reservation_type + ", check_in=" + check_in + ", check_out=" + check_out + "]";
	}
	
	
}
