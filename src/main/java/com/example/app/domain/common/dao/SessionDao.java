package com.example.app.domain.common.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.app.domain.common.dto.MemberDto;
import com.example.app.domain.common.dto.SessionDto;

public interface SessionDao {

	public List<SessionDto> selectAll() throws SQLException;

	public boolean insert(MemberDto dto) throws Exception;

}
