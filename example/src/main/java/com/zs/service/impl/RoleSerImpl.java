package com.zs.service.impl;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zs.dao.RoleMapper;
import com.zs.entity.Role;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.service.RoleSer;

@Service("roleSer")
public class RoleSerImpl implements RoleSer{
	@Resource
	private RoleMapper roleMapper;
	
	public EasyUIPage queryFenye(EasyUIAccept accept) {
		// TODO Auto-generated method stub
		return null;
	}

	public String add(Role obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public String update(Role obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public String delete(BigDecimal id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Role get(BigDecimal id) {
		return roleMapper.selectByPrimaryKey(id);
	}

}
