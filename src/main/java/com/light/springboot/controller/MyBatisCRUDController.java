package com.light.springboot.controller;

import java.util.Date;
import java.util.List;

import org.n3r.idworker.Sid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.light.springboot.pojo.IMoocJSONResult;
import com.light.springboot.pojo.SysUser;
import com.light.springboot.service.UserService;

@RestController
@RequestMapping("mybatis")
public class MyBatisCRUDController {
	//final static Logger log=LoggerFactory.getLogger(MyBatisCRUDController.class);
	@Autowired
	private UserService userService;
	
	@Autowired
	private Sid sid;
	
	@RequestMapping("/saveUser")
	public IMoocJSONResult saveUser() throws Exception {

		//log.info("保存用户，当前时间：{}，操作人：{}",new Date(),"jack");

		String userId = sid.nextShort();
		
		SysUser user = new SysUser();
		user.setId(userId);
		user.setUsername("springboot" + new Date());
		user.setNickname("springboot" + new Date());
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.saveUser(user);
		
		return IMoocJSONResult.ok("保存成功");
	}
	
	@RequestMapping("/updateUser")
	public IMoocJSONResult updateUser() {
		
		SysUser user = new SysUser();
		user.setId("1002");
		user.setUsername("10011001-updated" + new Date());
		user.setNickname("10011002-updated" + new Date());
		user.setPassword("10011002-updated");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.updateUser(user);
		
		return IMoocJSONResult.ok("更新成功");
	}
	
	@RequestMapping("/deleteUser")
	public IMoocJSONResult deleteUser(String userId) {
		
		userService.deleteUser(userId);
		
		return IMoocJSONResult.ok("删除成功");
	}
	
	@RequestMapping("/queryUserById")
	public IMoocJSONResult queryUserById(String userId) {
		
		return IMoocJSONResult.ok(userService.queryUserById(userId));
	}
	
	@RequestMapping("/queryUserList")
	public IMoocJSONResult queryUserList() {
		
		SysUser user = new SysUser();
		user.setUsername("imooc");
		user.setNickname("lee");
		
		List<SysUser> userList = userService.queryUserList(user);
		
		return IMoocJSONResult.ok(userList);
	}
	
	@RequestMapping("/queryUserListPaged")
	public IMoocJSONResult queryUserListPaged(Integer page) {

		if (page == null) {
			page = 1;
		}

		int pageSize = 5;
		
		SysUser user = new SysUser();
		//user.setNickname("test");
		
		List<SysUser> userList = userService.queryUserListPaged(user, page, pageSize);
		//return IMoocJSONResult.build(200,user.getNickname(),userList);
		return IMoocJSONResult.ok(userList);
	}
	
	@RequestMapping("/queryUserByIdCustom")
	public IMoocJSONResult queryUserByIdCustom(String userId) {
		
		return IMoocJSONResult.ok(userService.queryUserByIdCustom(userId));
	}
	
	@RequestMapping("/saveUserTransactional")
	public IMoocJSONResult saveUserTransactional() {
		
		String userId = sid.nextShort();
		
		SysUser user = new SysUser();
		user.setId(userId);
		user.setUsername("wang" + new Date());
		user.setNickname("wang" + new Date());
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.saveUserTransactional(user);
		
		return IMoocJSONResult.ok("保存成功");
	}
}
