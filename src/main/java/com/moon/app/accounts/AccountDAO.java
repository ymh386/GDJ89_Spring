package com.moon.app.accounts;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.moon.app.accounts.AccountDAO.";
	
	public int add(List<AccountDTO> list) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", list);
	}

}
