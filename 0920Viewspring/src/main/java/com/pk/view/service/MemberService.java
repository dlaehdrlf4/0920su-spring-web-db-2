package com.pk.view.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.view.dao.MemberDao;

@Service
public class MemberService {
	@Autowired
	private MemberDao memberDao;
	
	public String idcheck(String id) {
		return memberDao.idcheck(id);
	}
}
