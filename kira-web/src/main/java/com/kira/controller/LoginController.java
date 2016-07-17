package com.kira.controller;

import com.kira.domain.KiraMessage;
import com.kira.domain.UserInfo;
import com.kira.realm.MyRealm;
import com.kira.service.CheckLoginService;
import com.kira.service.UserInfoService;
import com.kira.utils.VerifyCodeUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by kira on 2016/7/12.
 */
@Controller
public class LoginController {
    public static final Logger log = Logger.getLogger(LoginController.class);
    @Autowired
    private CheckLoginService checkLoginService;

    @RequestMapping(value = "/toMain")
    public String toMain() {
        return "/main";
    }

    /**
     * 用户登出
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        SecurityUtils.getSubject().logout();
        return "/";
    }

    /**
     * 校验登录成功返回信息显示进度条跳转主界面
     *
     * @param userInfo
     * @param session
     * @param request
     * @param response
     */
    @RequestMapping(value = "/checkUserInfo", method = RequestMethod.POST)
    public void checkUserInfo(@ModelAttribute UserInfo userInfo, HttpSession session, HttpServletRequest request, HttpServletResponse response
    ) {
        checkLoginService.checkUserInfo(userInfo,session,request,response);
    }

    /**
     * 获取验证码图片和文本(验证码文本会保存在HttpSession中)
     */
    @RequestMapping(value = "/getVerifyCodeImage")
    public void getVerifyCodeImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置页面不缓存
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        String verifyCode = VerifyCodeUtil.generateTextCode(VerifyCodeUtil.TYPE_NUM_ONLY, 4, null);
        //将验证码放到HttpSession里面
        request.getSession().setAttribute("verifyCode", verifyCode);
        log.info("本次生成的验证码为[" + verifyCode + "],已存放到HttpSession中");
        //设置输出的内容的类型为JPEG图像
        response.setContentType("image/jpeg");
        BufferedImage bufferedImage = VerifyCodeUtil.generateImageCode(verifyCode, 90, 30, 3, true, Color.WHITE, Color.BLACK, null);
        //写给浏览器
        ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
    }

}
