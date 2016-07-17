package com.kira.service.impl;

import com.kira.dao.UserInfoMapper;
import com.kira.domain.KiraMessage;
import com.kira.domain.UserInfo;
import com.kira.service.CheckLoginService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * Created by kira on 2016/7/12.
 */
@Service
public class CheckLoginServiceImpl implements CheckLoginService {
    public static final Logger log = Logger.getLogger(CheckLoginServiceImpl.class);
    @Autowired
    private UserInfoMapper userInfoMapper;

    public boolean checkUserInfo(UserInfo userInfo) {
        int result = userInfoMapper.checkLoginUserInfo(userInfo);
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 校验登录返回信息
     * @param userInfo
     * @param session
     * @param request
     * @param response
     */
    public void checkUserInfo(UserInfo userInfo, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        PrintWriter writer = null;
        Subject currentUser = null;
        UsernamePasswordToken token = null;
        try {
            String verifyCode = (String) request.getSession().getAttribute("verifyCode");
            writer = response.getWriter();
            log.info("用户[" + userInfo.getUsername() + "]登录时输入的验证码为[" + userInfo.getVerifyCode() + "],HttpSession中的验证码为[" + verifyCode + "]");
            if (StringUtils.isEmpty(userInfo.getVerifyCode()) || !verifyCode.toLowerCase().equals(userInfo.getVerifyCode().toLowerCase())) {
                writer.print(KiraMessage.VERIFYCODE_ERROR);
                return;
            }
            String mPassword = DigestUtils.md5Hex(userInfo.getPassword());
            userInfo.setPassword(mPassword);
            token = new UsernamePasswordToken(userInfo.getUsername(), mPassword);
            token.setRememberMe(true);
            //获取当前的Subject
            currentUser = SecurityUtils.getSubject();
            log.info("对用户[" + userInfo.getUsername() + "]进行登录验证..验证开始");
            currentUser.login(token);
            log.info("对用户[" + userInfo.getUsername() + "]进行登录验证..验证通过");
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
        } catch (UnknownAccountException uae) {
            log.info("对用户[" + userInfo.getUsername() + "]进行登录验证..验证未通过,未知账户"+uae);
            writer.print("未知账户");
            return;
        } catch (IncorrectCredentialsException ice) {
            log.info("对用户[" + userInfo.getUsername() + "]进行登录验证..验证未通过,错误的凭证"+ice);
            writer.print("密码不正确");
            return;
        } catch (LockedAccountException lae) {
            log.info("对用户[" + userInfo.getUsername() + "]进行登录验证..验证未通过,账户已锁定"+lae);
            writer.print("账户已锁定");
            return;
        } catch (ExcessiveAttemptsException eae) {
            log.info("对用户[" + userInfo.getUsername() + "]进行登录验证..验证未通过,错误次数过多"+eae);
            writer.print("用户名或密码错误次数过多");
            return;
        } catch (AuthenticationException ae) {
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            log.info("对用户[" + userInfo.getUsername() + "]进行登录验证..验证未通过,堆栈轨迹如下"+ae);
            writer.print("用户名或密码不正确");
            return;
        } catch (Exception e) {
            log.error("checkUserInfo" + e);
            writer.print("出现未知错误");
            return;
        }
        /**
         * 认证成功跳转
         */
        if (currentUser.isAuthenticated()) {
            writer.print("404");
            log.info("用户[" + userInfo.getUsername() + "]登录认证通过");
            return;
        } else {
            token.clear();
        }
    }
}
