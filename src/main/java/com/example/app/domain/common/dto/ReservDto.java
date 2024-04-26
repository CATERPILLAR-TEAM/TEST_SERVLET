package com.example.app.domain.common.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReservDto {
	
	 private int room_info_id;
	 private int user_id;
	 private boolean reservation_type;
	 private  LocalDateTime checkIn = LocalDateTime.now();
	 private  LocalDateTime checkOut = LocalDateTime.now();
	 
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
	
	public LocalDateTime getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(LocalDateTime checkIn) {
		this.checkIn = checkIn;
	}
	public LocalDateTime getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(LocalDateTime checkOut) {
		this.checkOut = checkOut;
	}
	public ReservDto(int room_info_id, int user_id, boolean reservation_type, LocalDateTime checkIn,
			LocalDateTime checkOut) {
		super();
		this.room_info_id = room_info_id;
		this.user_id = user_id;
		this.reservation_type = reservation_type;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	
	
	public ReservDto(int room_info_id,  boolean reservation_type, LocalDateTime checkInDateTime,
			LocalDateTime checkOutDateTime) {
		super();
		this.room_info_id = room_info_id;
		
		this.reservation_type = reservation_type;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "ResvDto [room_info_id=" + room_info_id + ", user_id=" + user_id + ", reservation_type="
				+ reservation_type + ", checkIn=" + checkIn + ", checkOut=" + checkOut + "]";
	}
	 
	 

	 
	 
	 
	 
}