package com.bjts.board.dao.member;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bjts.board.domain.member.MemberVO;

@Repository
public class MemberDaoImpl implements MemberDao{

	DataSource dataSource;
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace="com.bjts.board.dao.member.MemberDao";

	JdbcTemplate template;

	private MemberVO memberVO;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	
	public MemberDaoImpl() {
	}
	
	
	
	@Override
	public void joinMemberInfo(MemberVO memberVo){
		sqlSession.insert(namespace + ".joinMemberInfo", memberVo);
		
	}


	@Override

	public String CheckPasswordMatch(String id) {
		return sqlSession.selectOne(namespace + ".CheckPasswordMatch", id);
  }
  
  @Override
	public MemberVO getMemberInfo(String id) {
		return sqlSession.selectOne(namespace + ".getMemberInfo", id);
	}


	@Override
	public void update_password(String id, String newpassword) {
		
		memberVO = new MemberVO();
		memberVO.setUserId(id);
		memberVO.setUserPassword(newpassword);
		
		sqlSession.update(namespace + ".updateMemberPassword", memberVO);
	}


	@Override
	public void delete(String id) {
		
		sqlSession.delete(namespace + ".deleteMemberInfo", id);
		
	}
	
	
	@Override
	public void update(MemberVO memberVo) {
		sqlSession.update(namespace + ".updateMemberInfo", memberVo);
	}


	@Override
	public String getValueNickname(String userNickname) {
		return sqlSession.selectOne(namespace + ".getValueNickname", userNickname);
  }
  
  @Override
    public String checkMemberId(String check_id) {
		return sqlSession.selectOne(namespace + ".checkMemberId",check_id);
	}


	@Override
	public String checkMemberNickname(String check_nickname) {
		return sqlSession.selectOne(namespace + ".checkMemberNickname",check_nickname);
	}
	
	
}
