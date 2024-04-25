package com.example.app.domain.common.dao;

import com.example.app.domain.common.dto.ReservDto;

public interface ReservDao {
	//INSERT
		boolean Insert(ReservDto dto) throws Exception;
}
