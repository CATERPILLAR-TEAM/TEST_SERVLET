package com.example.app.domain.common.service;

import com.example.app.domain.common.dao.MemberDao;
import com.example.app.domain.common.dao.MemberDaoImpl;
import com.example.app.domain.common.dao.common.ConnectionPool;

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
	public boolean login(String username, String password) {

		return false;
	}

}
