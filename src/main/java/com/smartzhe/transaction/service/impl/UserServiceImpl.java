package com.smartzhe.transaction.service.impl;

import com.smartzhe.transaction.dao.UserMapper;
import com.smartzhe.transaction.entity.User;
import com.smartzhe.transaction.service.UserService;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by luohuahua on 17/12/5.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public void insert() {
        User user = new User();
        user.setName("john123");
        userMapper.add(user);
    }

    private void throwExcp(){
        throw new RuntimeException("boom");
    }


    @Transactional
    @Override
    public void add1(){
        insert();
    }

    @Override
    @Transactional
    public void add2(){
        insert();
        throwExcp();
    }


    //
    /*@Transactional
    @Override
    public Integer add(User user) {
        add1();

        try {
            add2();
        } catch (Exception e) {
        }
        add1();
        return 1;
    }*/

    @Transactional
    @Override
    public Integer add(User user)  {

        ((UserService) AopContext.currentProxy()).add1();

        try {
            ((UserService) AopContext.currentProxy()).add2();
        } catch (Exception e) {
        }
        ((UserService) AopContext.currentProxy()).add1();
        return 1;
    }


    @Override
    public Integer addNo(User user) {
        int flag = userMapper.add(user);
        add(user);
        flag = 1 / 0;
        return flag;
    }

    @Transactional
    @Override
    public Integer deleteById(Integer id) {

        return userMapper.deleteById(id);
    }

    @Override
    public Integer deleteByIdNo(Integer id) {
        return null;
    }
}
