package com.ps.dao;

import com.ps.bo.UserDetailsBO;

public interface AuthenticationDAO {

	public int validate(UserDetailsBO bo);
}
