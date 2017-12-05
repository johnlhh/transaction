package com.smartzhe.transaction.core.datasource.dynic;

import java.lang.annotation.*;

/**
 * Created by luohuahua on 17/8/4.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String name();
}
