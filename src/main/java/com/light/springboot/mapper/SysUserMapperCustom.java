package com.light.springboot.mapper;

import java.util.List;

import com.light.springboot.pojo.SysUser;



public interface SysUserMapperCustom {
	
	List<SysUser> queryUserSimplyInfoById(String id);
}