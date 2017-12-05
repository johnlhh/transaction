package com.smartzhe.transaction.service;

import com.smartzhe.transaction.entity.User;

/**
 * Created by luohuahua on 17/12/5.
 */
public interface CommonService {

     Integer add(User user);


     Integer addNo(User user);


    Integer deleteById(Integer id);


    Integer deleteByIdNo(Integer id);


}
