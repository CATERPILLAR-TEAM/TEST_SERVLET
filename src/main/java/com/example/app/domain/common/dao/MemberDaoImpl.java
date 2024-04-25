package com.example.app.domain.common.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.app.domain.common.dao.common.CommonDao;
import com.example.app.domain.common.dto.MemberDto;

public class MemberDaoImpl extends CommonDao implements MemberDao {

	private static MemberDao instance;

	public static MemberDao getInstance() throws Exception {
		if (instance == null)
			instance = new MemberDaoImpl();
		return instance;
	}

	private MemberDaoImpl() throws Exception {
		System.out.println("[DAO] MemberDaoImpl's INIT " + conn);

	}

	@Override
	public boolean insert(MemberDto dto) throws Exception {
		pstmt = conn.prepareStatement("insert into member values(null,?,?,?,?,?,?,?,?)");
		pstmt.setString(1, dto.getRealname());
		pstmt.setString(2, dto.getBirth());
		pstmt.setBoolean(3, dto.isGender());
		pstmt.setString(4, dto.getPhone());
		pstmt.setString(5, dto.getEmail());
		pstmt.setString(6, dto.getUsername());
		pstmt.setString(7, dto.getPassword());
		pstmt.setString(8, dto.getConfrimPassword());
		int result = pstmt.executeUpdate();
		freeConnection(pstmt);
		return result > 0;
	}

	@Override
	public List<MemberDto> selectAll() throws SQLException {
		return new ArrayList<MemberDto>();
	}

	@Override
	public MemberDto select(String username, String password) throws Exception {
		pstmt = conn.prepareStatement("select * from member where username=?, password=?");
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		rs = pstmt.executeQuery();
		MemberDto dto = null;
		if (rs != null) {
			rs.next();
			dto = new MemberDto();
			dto.setId(rs.getInt("id"));
			dto.setUsername(rs.getString("username"));
			dto.setPassword(rs.getString("password"));
		}

		freeConnection(pstmt, rs);
		return dto;
	}

	@Override
	public boolean update(String username, String password, String email, Integer phone) throws Exception {
		return false;
	}

	@Override
	public boolean delete(int id) throws Exception {
		pstmt = conn.prepareStatement("delete from member where id=?");
		pstmt.setInt(1, id);
		int result = pstmt.executeUpdate();
		freeConnection(pstmt);
		return result > 0;
	}
}
