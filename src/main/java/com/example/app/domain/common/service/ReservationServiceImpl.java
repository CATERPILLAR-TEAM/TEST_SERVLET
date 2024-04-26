package com.example.app.domain.common.service;

import java.sql.SQLException;

import com.example.app.domain.common.dao.ReservationDao;
import com.example.app.domain.common.dao.ReservationDaoImpl;
import com.example.app.domain.common.dao.common.ConnectionPool;
import com.example.app.domain.common.dto.ReservationDto;

public class ReservationServiceImpl implements ReservationService {

	private ReservationDao dao;
	private ConnectionPool connectionPool;

	private static ReservationService instance;

	public static ReservationService getInstance() throws Exception {
		if (instance == null) {
			instance = new ReservationServiceImpl();
		}
		return instance;
	}

	private ReservationServiceImpl() throws Exception {
		dao = (ReservationDao) ReservationDaoImpl.getInstance();
		this.connectionPool = ConnectionPool.getInstance();
	}

	// delete
	public boolean removeReserv(int user_id) throws Exception {
		connectionPool.txStart();
		boolean isDeleted = dao.Delete(user_id);

		connectionPool.txCommit();
		return isDeleted;

	}

	@Override
	public boolean removeReserv(String user_id) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean updateReserv(ReservationDto dto) throws SQLException {
		// TODO Auto-generated method stub
		return true;
	}

}
