package com.example.app.domain.common.service;

import com.example.app.domain.common.dto.ReservDto;

public interface ReservService {
	boolean reservRegister(ReservDto dto) throws Exception;

}
