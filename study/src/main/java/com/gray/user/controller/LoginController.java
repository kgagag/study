package com.gray.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gray.user.entity.User;
import com.gray.user.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/test") 
public class LoginController {
	@Autowired
	private UserServiceImpl userService;

@RequestMapping("/dologin.do") //url
public String dologin(User user, Model model){
	if(userService.doUserLogin(user)){
		model.addAttribute("successMsg", "登陆成功！");//返回到页面说夹带的参数
		model.addAttribute("name", user.getUsername());
		return "/success";//返回的页面
	}else{
		model.addAttribute("failMsg", "用户不存在或密码错误！");
		return "/fail";
	}	
}
}
