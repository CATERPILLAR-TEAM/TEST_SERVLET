package com.example.app.domain.common.service;

import java.util.List;
import java.util.Map;


import com.example.app.domain.common.dto.ReservDto;

public interface ReservService {
	boolean reservRegister(ReservDto dto) throws Exception;
	
	ReservDto getReservation(int userId) throws Exception;
	
	
}
