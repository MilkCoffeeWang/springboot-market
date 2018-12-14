package com.light.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/helloworld")
    public String helloworld() {
        return "helloworld";
    }
	@GetMapping("/print")
    public String print() {
        return "index.jsp";
    }
}
