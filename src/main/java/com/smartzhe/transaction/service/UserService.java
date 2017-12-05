package com.smartzhe.transaction.service;

import com.smartzhe.transaction.entity.User;

/**
 * Created by luohuahua on 17/12/5.
 */
public interface UserService {

     Integer add(User user);

     void add1();
     void add2();


     Integer addNo(User user);


    Integer deleteById(Integer id);


    Integer deleteByIdNo(Integer id);


}
