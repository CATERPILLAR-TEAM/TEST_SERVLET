package com.example.app.domain.common.service;

import java.util.List;

import com.example.app.domain.common.dao.MemberDao;
import com.example.app.domain.common.dao.MemberDaoImpl;
import com.example.app.domain.common.dao.SessionDao;
import com.example.app.domain.common.dao.common.ConnectionPool;
import com.example.app.domain.common.dto.MemberDto;
import com.example.app.domain.common.dto.SessionDto;

public class MemberServiceImpl implements MemberService {

	private MemberDao memberDao;
	private SessionDao sessionDao;
	private List<SessionDto> sessionUserList;
	private ConnectionPool connectionPool;

	private static MemberService instance;

	public static MemberService getInstance() throws Exception {
		if (instance == null)
			instance = new MemberServiceImpl();
		return instance;
	}

	private MemberServiceImpl() throws Exception {

		memberDao = MemberDaoImpl.getInstance();
		this.connectionPool = ConnectionPool.getInstance();
	}

	@Override
	public boolean deleteMember(int id) throws Exception {
		connectionPool.txStart();
		memberDao.delete(id);
		connectionPool.txCommit();
		return true;
	}

	@Override
	public boolean login(String username, String password) throws Exception {
		connectionPool.txStart();
		sessionUserList = sessionDao.selectAll();

		// 1 받은 username과 password와 일치하는 member가 있는지 테이블 검색
		MemberDto dto = memberDao.select(username, password);

		// 2 dto가 존재한다면 로그인
		if (dto != null) {
			// 3 세션 테이블에 user id 저장
			sessionDao.insert(dto);
		} else { // 존재하지 않는다면 회원가입

		}

		// 1 session List에 동일한 세션 정보가 있는지 확인
		for (SessionDto memberId : sessionUserList)

			// 2 로그인 상태가 아니라면 member 테이블로부터 동일한 member id 가져오기

			// 3 password 일치 확인

			// 4 password 일치한다면 session table에 member id 저장

			connectionPool.txCommit();
		return false;
	}

	@Override
	public boolean register(MemberDto memberDto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
