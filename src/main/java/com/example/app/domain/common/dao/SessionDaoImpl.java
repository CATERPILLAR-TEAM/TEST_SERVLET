package com.example.app.domain.common.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.app.domain.common.dao.common.CommonDao;
import com.example.app.domain.common.dto.MemberDto;
import com.example.app.domain.common.dto.SessionDto;

public class SessionDaoImpl extends CommonDao implements SessionDao {

	private static SessionDao instance;

	public static SessionDao getInstance() throws Exception {
		if (instance == null)
			instance = new SessionDaoImpl();
		return instance;
	}

	private SessionDaoImpl() throws Exception {
		System.out.println("[DAO] SessionDaoImpl's INIT " + conn);
	}

	@Override
	public List<SessionDto> selectAll() throws SQLException {
		pstmt = conn.prepareStatement("select * from session");
		rs = pstmt.executeQuery();
		List<SessionDto> list = new ArrayList<>();
		SessionDto dto = null;
		if (rs != null) {
			while (rs.next()) {
				dto = new SessionDto();
				dto.setSession_id(rs.getInt("id"));
				dto.setMember_id(rs.getInt("member_id"));
				list.add(dto);
			}
		}
		freeConnection(pstmt, rs);
		return list;
	}

	@Override
	public boolean insert(MemberDto dto) throws Exception {
		pstmt = conn.prepareStatement("insert into session values(?, ?)");
		pstmt.setInt(1, 0);
		pstmt.setInt(2, dto.getId());
		int result = pstmt.executeUpdate();

		freeConnection(pstmt);
		return result > 0;
	}

}
