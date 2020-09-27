package com.bjts.board.dao.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bjts.board.domain.member.MemberVO;

@Repository
public class MemberDaoImpl implements MemberDao{
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace="com.bjts.board.dao.member.MemberDao";

	private MemberVO memberVO;
	
	@Override
	public void joinMemberInfo(MemberVO memberVo){
		sqlSession.insert(namespace + ".joinMemberInfo", memberVo);
		
	}


	@Override

	public String getMemberPassword(String id) {
		return sqlSession.selectOne(namespace + ".getMemberPassword", id);
  }
  
  @Override
	public MemberVO getMemberInfo(String id) {
		return sqlSession.selectOne(namespace + ".getMemberInfo", id);
	}


	@Override
	public void updateMemberPassword(String id, String newpassword) {
		
		memberVO = new MemberVO();
		memberVO.setUserId(id);
		memberVO.setUserPassword(newpassword);
		
		sqlSession.update(namespace + ".updateMemberPassword", memberVO);
	}


	@Override
	public void deleteMemberInfo(String id) {
		
		sqlSession.delete(namespace + ".deleteMemberInfo", id);
		
	}
	
	@Override
	public void updateMemberInfo(MemberVO memberVo) {
		System.out.println(memberVo.getUserId());
		sqlSession.update(namespace + ".updateMemberInfo", memberVo);
		System.out.println("매퍼 통과 updateInfo의 memberVo 값은 : " + memberVo.toString());
	}
  
	@Override
    public String getMemberId(String check_id) {
		return sqlSession.selectOne(namespace + ".getMemberId",check_id);
	}


	@Override
	public String getMemberNickname(String check_nickname) {
		return sqlSession.selectOne(namespace + ".getMemberNickname",check_nickname);
	}


	@Override
	public String checkMemberPassword(String id) {
		return sqlSession.selectOne(namespace + ".checkMemberPassword", id);
	}


	@Override
	public String getMemberNicknameById(String id) {
		return sqlSession.selectOne(namespace + ".getMemberNicknameById", id);
	}
	
	
}
