package com.communication.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.RoleDao;
import com.communication.entity.Role;

@Service
public class RoleService extends BaseService<Role> {
	
	@Resource
	private void setDao(RoleDao dao){
		super.setDao(dao);
	}

}
