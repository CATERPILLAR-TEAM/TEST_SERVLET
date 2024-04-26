package com.example.app.domain.common.service;

import java.sql.SQLException;

import com.example.app.domain.common.dto.ReservationDto;

public interface ReservationService {

	boolean removeReserv(String user_id) throws Exception;

	boolean updateReserv(ReservationDto dto) throws SQLException; 

}
