package com.kira.service;

import com.kira.domain.UserInfo;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by rensh on 2016/7/7.
 */
@Transactional
public interface UserInfoService {
    UserInfo getUserById(int id);

    int insert(UserInfo userInfo);

    UserInfo getUserInfoByUsername(String username);
}
