package com.example.app.domain.common.service;

import javax.servlet.http.HttpSession;

import com.example.app.domain.common.dto.MemberDto;

public interface MemberService {

	boolean deleteMember(int id) throws Exception;

	boolean register(MemberDto memberDto) throws Exception;

	boolean login(String username, String password, HttpSession session) throws Exception;

	boolean logout(int sessionId) throws Exception;
}
