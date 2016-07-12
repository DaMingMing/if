package com.kira.controller;

import com.kira.domain.UserInfo;
import com.kira.service.CheckLoginService;
import com.kira.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by kira on 2016/7/12.
 */
@Controller
public class LoginController {
    @Autowired
    private CheckLoginService checkLoginService ;
    @RequestMapping(value="/login", method= RequestMethod.POST)
    public String login(@ModelAttribute UserInfo userInfo, HttpSession session){

        if(checkLoginService.checkUserInfo(userInfo)){
            return "redirect:/main";
        }else{
            return "redirect:/failed";
        }



    }

}
