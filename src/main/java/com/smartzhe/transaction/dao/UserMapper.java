package com.smartzhe.transaction.dao;


import com.smartzhe.transaction.entity.User;

public interface UserMapper {

    Integer deleteById(Integer id);

    Integer add(User user);

}