package com.kira.service;

import com.kira.domain.UserInfo;

/**
 * Created by rensh on 2016/7/7.
 */
public interface UserInfoService {
    UserInfo getUserById(int id);

    int insert(UserInfo userInfo);
}
