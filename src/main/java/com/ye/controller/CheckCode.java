package com.ye.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ye.utils.ValidateCode;

@Controller
public class CheckCode {
	@RequestMapping("/checkCode")
	public void getCode(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
		resp.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expire", 0);
		ValidateCode validateCode = new ValidateCode();
		try {
			validateCode.getRandcode(req, resp);//输出验证码图片方法
		} catch (Exception e) {
			e.printStackTrace();
    	}
	}
}
