package com.kira.service.impl;

import com.kira.dao.UserInfoMapper;
import com.kira.domain.UserInfo;
import com.kira.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by rensh on 2016/7/7.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{
    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo getUserById(int id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    public int insert(UserInfo userInfo) {
        int i = userInfoMapper.insert(userInfo);
        System.out.print(i);
        return i;
    }
}
