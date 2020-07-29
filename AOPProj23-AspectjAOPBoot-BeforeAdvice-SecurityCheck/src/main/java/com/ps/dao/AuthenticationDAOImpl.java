package com.ps.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ps.bo.UserDetailsBO;

@Repository("authDAO")
public class AuthenticationDAOImpl implements AuthenticationDAO {
	private static final String Auth_Query="SELECT COUNT(*) FROM USER_INFO WHERE USERNAME=? AND PASSWORD=?";
	
	@Autowired
	private JdbcTemplate jt;
		
	@Override
	public int validate(UserDetailsBO bo) {
		System.out.println("AuthenticationDAOImpl.validate(-)");
		int count=0;
		count=jt.queryForObject(Auth_Query,Integer.class, bo.getUsername(),bo.getPassword());
		return count;
	}

}
