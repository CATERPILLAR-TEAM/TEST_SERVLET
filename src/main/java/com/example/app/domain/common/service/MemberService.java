package com.example.app.domain.common.service;

import com.example.app.domain.common.dto.MemberDto;

public interface MemberService {

	boolean deleteMember(int id) throws Exception;

	boolean login(String username, String password) throws Exception;

	boolean register(MemberDto memberDto) throws Exception;
}
