package com.kira.service;

import com.kira.domain.UserInfo;

/**
 * Created by kira on 2016/7/12.
 */
public interface CheckLoginService {
    /**
     * 校验登录的用户在数据库中是否存在
     * @param userInfo
     * @return
     */
    boolean checkUserInfo(UserInfo userInfo);
}
