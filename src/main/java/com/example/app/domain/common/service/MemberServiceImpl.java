package com.example.app.domain.common.service;

import com.example.app.domain.common.dao.MemberDao;
import com.example.app.domain.common.dao.MemberDaoImpl;
import com.example.app.domain.common.dao.common.ConnectionPool;
import com.example.app.domain.common.dto.MemberDto;

public class MemberServiceImpl implements MemberService {

	private MemberDao dao;
	private ConnectionPool connectionPool;

	private static MemberService instance;

	public static MemberService getInstance() throws Exception {
		if (instance == null)
			instance = new MemberServiceImpl();
		return instance;
	}

	private MemberServiceImpl() throws Exception {

		dao = MemberDaoImpl.getInstance();
		this.connectionPool = ConnectionPool.getInstance();
	}

	@Override
	public boolean deleteMember(int id) throws Exception {
		connectionPool.txStart();
		dao.delete(id);
		connectionPool.txCommit();
		return true;
	}

	@Override
	public boolean register(MemberDto memberDto) throws Exception {
		connectionPool.txStart();
		boolean isSuccess = dao.insert(memberDto);
		connectionPool.txCommit();
		return isSuccess;

	}

	@Override
	public boolean login(String username, String password) throws Exception {

		// session에 해당 member가 존재하는가?
		dao.select(username, password);
		// member table에 해당 member가 존재하는가?
		// 해당 member의 password는 일치한가?
		// session에 member 저장!!
		return false;
	}

}
