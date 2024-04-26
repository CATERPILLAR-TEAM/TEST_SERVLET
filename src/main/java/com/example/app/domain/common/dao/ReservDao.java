package com.example.app.domain.common.dao;

import java.util.List;

import com.example.app.domain.common.dto.ReservDto;

public interface ReservDao {
	//INSERT
		boolean Insert(ReservDto dto) throws Exception;
		
	//SELECT
		ReservDto Select(int userId) throws Exception;
}
