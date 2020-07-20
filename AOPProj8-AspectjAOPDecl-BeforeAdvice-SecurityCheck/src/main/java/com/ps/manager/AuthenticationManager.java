package com.ps.manager;

import org.springframework.beans.BeanUtils;

import com.ps.bo.UserDetailsBO;
import com.ps.dao.AuthenticationDAO;
import com.ps.dto.UserDetailsDTO;

public class AuthenticationManager {
	private AuthenticationDAO dao;
	private ThreadLocal<UserDetailsDTO> threadLocal=new ThreadLocal();

	public AuthenticationManager(AuthenticationDAO dao) {
		this.dao = dao;
	}
	
	public void signIn(String username, String password) {
		System.out.println("AuthenticationManager.signIn()");
		UserDetailsDTO dto=null;
		dto=new UserDetailsDTO();
		//convert username password in to dto object
		dto.setUsername(username);
		dto.setPassword(password);
		//keep object in threadLocal(that works like Session)
		threadLocal.set(dto);
	}
	
	public void signOut() {
		System.out.println("AuthenticationManager.signOut()");
		threadLocal.remove();
	}
	
	public boolean isAuthenticated() {
		System.out.println("AuthenticationManager.isAuthenticated()");
		UserDetailsDTO dto=null;
		UserDetailsBO bo=null;
		int count=0;
		//keep threadLocal object in dto
		dto=threadLocal.get();
		//keep dto object in bo 
		bo=new UserDetailsBO();
		BeanUtils.copyProperties(dto, bo);
		//validate username password from database
		count=dao.validate(bo);
		return count==0?false:true;
	}
	
	
	
	
}
