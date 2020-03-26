package com.ye.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ye.pojo.ResultInfo;
import com.ye.pojo.User;
import com.ye.service.RegisterInfoService;
import com.ye.service.UserService;

@Controller
public class UserController {
	@Resource
	private UserService userServiceImpl;
	@Resource
	private RegisterInfoService registerInfoServiceImpl;
	
	//用户登录
	@RequestMapping("/login")
	@ResponseBody
	public ResultInfo login(User user,String code,HttpSession session) {
		//从session中获取验证码
		String code_session=(String)session.getAttribute("randomCode");
		ResultInfo info = new ResultInfo();
		if(code.equalsIgnoreCase(code_session)) {
			//验证码正确
			User u=userServiceImpl.login(user);	
			if(u!=null) {
				info.setFlag(true);
				info.setData(u.getRid());
				session.setAttribute("user", u);
			}else {
				info.setFlag(false);
				info.setErrorMsg("用户名或密码错误,登陆失败！");
			}
		}else {
			info.setFlag(false);
			info.setErrorMsg("验证码错误,登陆失败！");
		}
		return info;
	}
	
	//获取session中User信息
	@RequestMapping("/getUser")
	@ResponseBody
	public User getUserInfo(HttpSession session) {
		User user = (User)session.getAttribute("user");
		return user;
	}
	//修改密码
	@RequestMapping("/modifyPwd")
	@ResponseBody
	public boolean changePwd(String oldPwd,String newPwd,HttpSession session) {
		User user = (User)session.getAttribute("user");
		int index=userServiceImpl.editPwd(oldPwd,newPwd, user.getId());
		boolean flag=false;
		if(index>0) {
			//修改成功
			session.removeAttribute("user");
			flag=true;
		}
		return flag;
	}
	//用户退出登录
	@RequestMapping("/exit")
	@ResponseBody
	public String exitLogin(HttpSession session) {
		session.removeAttribute("user");
		return "/educational/index.html";
	}
}
