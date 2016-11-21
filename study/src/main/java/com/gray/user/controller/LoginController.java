package com.gray.user.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gray.common.ResultTool;
import com.gray.user.entity.PayVO;
import com.gray.user.entity.User;
import com.gray.user.service.impl.UserServiceImpl;
import com.gray.util.DateUtil;

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

    @ResponseBody
    @RequestMapping("/getpay.json") // url
    public Object getPay() {
        List<PayVO> ls = this.userService.getPay(1479139199);
        System.out.println("总订单数：" + ls.size());
        // 分成60份
        List<Integer> times = splitTime();
        List<Map<Object, Object>> res = new ArrayList<Map<Object, Object>>();
        for (int i = 0; i < times.size(); i++) {
            Map<Object, Object> map = new HashMap<Object, Object>();
            map.put("time", stampToDate(String.valueOf((times.get(i)))));
            map.put("total", getTotalByTime(times.get(i), ls));
            res.add(map);
        }

        Collections.reverse(res);
        return res;
    }

    private double getTotalByTime(int time, List<PayVO> ls) {
        double total = 0;
        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i).getTime() <= time) {
                total = total + ls.get(i).getMoney();
            }
        }
        return total;
    }

    private List<Integer> splitTime() {

        List<Integer> ls = new ArrayList<Integer>();
        int now = DateUtil.nowTimeStamp();
        // ls.add(1479139199);
        ls.add(now);
        for (int i = 0; i < 60 * 24; i++) {
            now = now - 60;
            if (now - 1479139199 >= 0) {
                ls.add(now);
            }
        }
        ls.add(1479139199);
        return ls;
    }

    public static String stampToDate(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt * 1000);
        res = simpleDateFormat.format(date);
        return res;
    }
}
