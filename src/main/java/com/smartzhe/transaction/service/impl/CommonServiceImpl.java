package com.smartzhe.transaction.service.impl;

import com.smartzhe.transaction.dao.UserMapper;
import com.smartzhe.transaction.entity.User;
import com.smartzhe.transaction.service.CommonService;
import com.smartzhe.transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by luohuahua on 17/12/5.
 */
@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Transactional
    @Override
    public Integer add(User user) {
        userMapper.add(user);
        int flag =  userService.add(user);


        return flag;
    }

    @Override
    public Integer addNo(User user) {
        userMapper.add(user);
        int flag =  userService.add(user);
        flag = 1/0;
        return flag;
    }

    @Transactional
    @Override
    public Integer deleteById(Integer id) {
        return null;
    }

    @Override
    public Integer deleteByIdNo(Integer id) {
        return null;
    }
}
