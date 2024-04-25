package com.example.app.domain.common.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.example.app.domain.common.dto.ReservDto;

public class ReservDaoImpl extends CommonDao implements ReservDao{

	private static ReservDao instance ;
	public static ReservDao getInstance() throws Exception {
		if(instance==null)
			instance=new ReservDaoImpl();
		return instance;
	}
	public ReservDaoImpl() throws Exception {
		System.out.println("[DAO] ReservDaoImpl's INIT.." + conn);
	}

	@Override
	public boolean Insert(ReservDto dto) throws Exception {
		pstmt = conn.prepareStatement("insert into book values(?,?,?,?,?)");
		pstmt.setInt(1, dto.getRoom_info_id());
		pstmt.setInt(2, dto.getUser_id());
		pstmt.setBoolean(3, dto.isReservation_type());
		pstmt.setTimestamp(4, Timestamp.valueOf(dto.getCheckIn()));
		pstmt.setTimestamp(5, Timestamp.valueOf(dto.getCheckOut()));
		int result = pstmt.executeUpdate();
		
		freeConnection(pstmt);
		return result>0;
	}

	
	
}
