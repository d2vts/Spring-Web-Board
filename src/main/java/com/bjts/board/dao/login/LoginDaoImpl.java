package com.bjts.board.dao.login;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDaoImpl implements LoginDao{

    @Autowired
    private SqlSession sqlSession;

    private static final String namespace="com.bjts.board.dao.login.LoginDao";

    @Override
    public String valueCheckId(String id) {
        String userId = sqlSession.selectOne(namespace + ".valueCheckId", id);
        return userId;
    }

    @Override
    public String valueCheckPassword(String id) {
        return sqlSession.selectOne(namespace + ".valueCheckPassword", id);
    }

    @Override
    public String getValueNickname(String id) {
        return sqlSession.selectOne(namespace + ".getValueNickname", id);
    }

}
