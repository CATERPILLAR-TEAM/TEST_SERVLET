package com.example.app.domain.common.dao;

import com.example.app.domain.common.dto.MemberDto;

public interface SessionDao {
	boolean exists(MemberDto dto) throws Exception;

	boolean insert(MemberDto memberDto) throws Exception;
}
