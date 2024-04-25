package com.example.app.domain.common.service;

import com.example.app.domain.common.dao.ConnectionPool;
import com.example.app.domain.common.dao.ReservDao;
import com.example.app.domain.common.dao.ReservDaoImpl;
import com.example.app.domain.common.dto.ReservDto;

public class ReservServiceImpl implements ReservService{
	
	private ReservDao dao;
	private ConnectionPool connectionPool;
	
	private static ReservService instance;
	public static ReservService getInstance() throws Exception {
		if(instance==null)
			instance=new ReservServiceImpl();
		return instance;
	}
	
	private ReservServiceImpl() throws Exception {
		dao = ReservDaoImpl.getInstance();
		this.connectionPool = ConnectionPool.getInstance();
	}
	
	
	@Override
	public boolean reservRegister(ReservDto dto) throws Exception {
		//TX
			connectionPool.txStart();			//05-01 Day TX
			boolean result = dao.Insert(dto);	//05-01 Day TX
			connectionPool.txCommit();			//05-01 Day TX
				
				return result;
	} 

	
}
