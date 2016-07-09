package com.kira.controller;

import com.kira.domain.UserInfo;
import com.kira.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by rensh on 2016/7/9.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserInfoService userInfoService ;

    @RequestMapping("/showInfo/{userId}")
    public String showUserInfo(ModelMap modelMap, @PathVariable int userId) {
        UserInfo userInfo = userInfoService.getUserById(userId);
        modelMap.addAttribute("userInfo", userInfo);
        return "/user/showInfo" ;
    }
}