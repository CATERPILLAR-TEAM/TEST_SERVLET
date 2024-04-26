package com.example.app.domain.common.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;



import com.example.app.domain.common.dao.common.CommonDao;
import com.example.app.domain.common.dto.ReservationDto;

public class ReservationDaoImpl extends CommonDao{
	
	private static ReservationDaoImpl instance;
	
	public static ReservationDaoImpl getInstance() throws Exception {
		if(instance == null) {
			instance = new ReservationDaoImpl();
		}
		return instance;
	}
	
	public ReservationDaoImpl() throws Exception {
		System.out.println("[DAO] ReservationDaoImpl's INIT" + conn);
	}
	
	// insert
	
	// update
	public boolean Update() {
		return false;
	}
	
	// delete
	public boolean Delete() {
		return false;
	}
	
	// select
	public ReservationDto Select(int room_info_id) {
		return null;
	}
	public ReservationDto Select(int room_info_id, int user_id) throws SQLException {
		pstmt = conn.prepareStatement("select * from accomodation where user_id=?, room_info_id=?");
		pstmt.setInt(1, user_id);
		pstmt.setInt(2, room_info_id);
		rs = pstmt.executeQuery();
		ReservationDto dto = null;
		if(rs!=null && rs.next()) {
			dto = new ReservationDto();
			dto.setRoom_info_id(rs.getInt("room_info_id"));
			dto.setUser_id(rs.getInt("user_id"));
			dto.setReservation_type(rs.getBoolean("reservation_type"));
			if(rs.getDate("check_in")!=null) 
				dto.setCheck_in(new Timestamp(rs.getDate("check_in").getTime()).toLocalDateTime());	
			
			if(rs.getDate("check_out")!=null)
				dto.setCheck_out(new Timestamp(rs.getTimestamp("check_out").getTime()).toLocalDateTime());
			
			
		}
		
		return dto;
	}
	
	// select
	public List<ReservationDto> SelectAll(int user_id) throws SQLException {
		pstmt = conn.prepareStatement("select * from accomodation where user_id=?");
		pstmt.setInt(1, user_id);
		rs = pstmt.executeQuery();
		List<ReservationDto> list = new ArrayList();
		ReservationDto dto = null;
		if(rs!=null) {
			while(rs.next()) {
				dto = new ReservationDto();
				dto.setRoom_info_id(rs.getInt("room_info_id"));
				dto.setUser_id(rs.getInt("user_id"));
				dto.setReservation_type(rs.getBoolean("reservation_type"));
				if(rs.getDate("check_in")!=null) 
					dto.setCheck_in(new Timestamp(rs.getDate("check_in").getTime()).toLocalDateTime());	
				
				if(rs.getDate("check_out")!=null)
					dto.setCheck_out(new Timestamp(rs.getTimestamp("check_out").getTime()).toLocalDateTime());
				list.add(dto);
			}
			
		}
		
		return list;
	}
	
	// selectAll
	public List<ReservationDto> SelectAll() throws SQLException {
		pstmt = conn.prepareStatement("select * from accomodation");
		
		rs = pstmt.executeQuery();
		List<ReservationDto> list = new ArrayList();
		ReservationDto dto = null;
		if(rs!=null) {
			while(rs.next()) {
				dto = new ReservationDto();
				dto.setRoom_info_id(rs.getInt("room_info_id"));
				dto.setUser_id(rs.getInt("user_id"));
				dto.setReservation_type(rs.getBoolean("reservation_type"));
				if(rs.getDate("check_in")!=null) 
					dto.setCheck_in(new Timestamp(rs.getDate("check_in").getTime()).toLocalDateTime());	
				
				if(rs.getDate("check_out")!=null)
					dto.setCheck_out(new Timestamp(rs.getTimestamp("check_out").getTime()).toLocalDateTime());
				list.add(dto);
			}
		}
		return list;
	}

	
		

}
