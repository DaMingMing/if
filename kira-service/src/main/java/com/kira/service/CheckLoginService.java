package com.kira.service;

import com.kira.domain.UserInfo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Created by kira on 2016/7/12.
 */
public interface CheckLoginService {
    /**
     * 校验登录的用户在数据库中是否存在
     * @param userInfo
     * @return
     */
    void checkUserInfo(UserInfo userInfo,HttpSession session,HttpServletRequest request, HttpServletResponse response);
}
