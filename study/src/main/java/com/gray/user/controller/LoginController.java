package com.gray.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gray.common.ResultTool;
import com.gray.user.entity.User;
import com.gray.user.service.impl.UserServiceImpl;

@Transactional
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserServiceImpl userService;

    @ResponseBody
    @RequestMapping(value = "/dologin.json", method = RequestMethod.GET) // url11
    public Object dologin(User user) {
        if (userService.doUserLogin(user)) {
            return ResultTool.success(user);
        }
        else {
            return ResultTool.success();
        }
    }

    /**
     * 测试事务
     */
    @RequestMapping("/testTransaction.json") // url
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
