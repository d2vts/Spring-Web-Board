package com.bjts.board.dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.bjts.board.domain.member.MemberVO;

import temp.Constant;

public class MemberDaoImpl {

	DataSource dataSource;

	JdbcTemplate template = null;

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	
	public MemberDaoImpl() {
	}
	
	
	
	
	public void join(String userId, String userPassword, String userName, String userNickname,
			String userEmail, String userAddress, String userGender){
		
		template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				String SQL = "INSERT INTO member VALUES(MEMBER_ID_SEQ.NEXTVAL,?,?,?,?,?,?,?,sysdate)";
				PreparedStatement pstmt = conn.prepareStatement(SQL);
				
				pstmt.setString(1, userId);
				pstmt.setString(2, userPassword);
				pstmt.setString(3, userName);
				pstmt.setString(4, userNickname);
				pstmt.setString(5, userEmail);
				pstmt.setString(6, userAddress);
				pstmt.setString(7, userGender);
				
				return pstmt;
			}
		});
		
	}
	
	
}
