package com.kira.service.impl;

import com.kira.dao.UserInfoMapper;
import com.kira.domain.UserInfo;
import com.kira.service.CheckLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kira on 2016/7/12.
 */
@Service
public class CheckLoginServiceImpl implements CheckLoginService {
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
}
