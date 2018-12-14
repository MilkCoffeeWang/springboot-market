package com.light.springboot.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LeeJSONResult {
	// 定义Jackson对象
	private static final ObjectMapper MAPPER = new ObjectMapper();

	// 响应业务状态
	private Integer status;

	// 响应消息
	private String mag;

	// 响应中的数据
	private Object data;

	private String ok;// 不可用

	public LeeJSONResult(Integer status2, String msg, Object data2) {
		// TODO Auto-generated constructor stub
	}

	public static LeeJSONResult build(Integer status, String msg, Object data) {
		return new LeeJSONResult(status, msg, data);

	}
}
