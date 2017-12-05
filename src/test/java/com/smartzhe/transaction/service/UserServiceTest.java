package com.smartzhe.transaction.service;

/**
 * Created by luohuahua on 17/12/5.
 */

import com.smartzhe.transaction.Application;
import com.smartzhe.transaction.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)

public class UserServiceTest {


    @Autowired
    private UserService userService;

    @Autowired
    private CommonService commonService;


    /**
     * userService.add1 没有事务 调用了有事务的userService.add 没有回滚
     */
    @Test
    public void test_add1(){
        User user = new User();
        user.setName("john");
        userService.add1(user);
    }

    /**
     * commonService.addNo没有事务 调用了有事务的userService.add 回滚了
     */
    @Test
    public void test_comm_add(){
        User user = new User();
        user.setName("john-common");
        commonService.addNo(user);
    }

    @Test
    public void test_addNo(){
        User user = new User();
        user.setName("john");
        userService.addNo(user);
    }

    /*




    @Test
    public void test_comm_addNo(){
        User user = new User();
        user.setName("john-common");
        commonService.addNo(user);
    }*/

}
