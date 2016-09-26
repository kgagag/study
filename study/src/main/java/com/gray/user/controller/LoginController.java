package com.gray.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gray.user.entity.User;
import com.gray.user.service.impl.UserServiceImpl;

@Transactional
@Controller
@RequestMapping("/test")
public class LoginController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/dologin.do") // url
    public String dologin(User user, Model model) {
        if (userService.doUserLogin(user)) {
            model.addAttribute("successMsg", "");
            model.addAttribute("name", user.getUsername());
            return "/success";
        }
        else {
            model.addAttribute("failMsg", "");
            return "/fail";
        }
    }

    /**
     * 测试事务
     */
    @RequestMapping("/testTransaction.do") // url
    public Object testTransaction() {
        for (int i = 0; i < 100; i++) {
            User u = new User();
            u.setPassword(i + "");
            u.setUsername(i + "");
            this.userService.insert(u);
        }
        return null;
    }

}
