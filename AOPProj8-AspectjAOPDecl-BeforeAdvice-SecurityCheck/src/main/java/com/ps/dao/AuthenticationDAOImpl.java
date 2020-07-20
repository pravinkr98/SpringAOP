package com.ps.dao;


import org.springframework.jdbc.core.JdbcTemplate;

import com.ps.bo.UserDetailsBO;

public class AuthenticationDAOImpl implements AuthenticationDAO {
	private static final String Auth_Query="SELECT COUNT(*) FROM USER_INFO WHERE USERNAME=? AND PASSWORD=?";
	private JdbcTemplate jt;
		
	public AuthenticationDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public int validate(UserDetailsBO bo) {
		System.out.println("AuthenticationDAOImpl.validate(-)");
		int count=0;
		count=jt.queryForObject(Auth_Query,Integer.class, bo.getUsername(),bo.getPassword());
		return count;
	}

}
