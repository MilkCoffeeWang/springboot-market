package com.light.springboot.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.light.springboot.pojo.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/getUser")
    public User helloworld() {
		User user=new User();
		user.setAge(23);
		user.setBirthday(new Date());
		user.setDesc("矮矬窮");
		user.setName("wang");
		user.setPassword("123456");
        return user;
    }
	@RequestMapping("/print")
    public String print() {
        return "index.jsp";
    }
}
