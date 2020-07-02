package com.coroutine.bod.localkotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @ClassName: IPermiss
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-06-12
 */
@Target(value = {ElementType.TYPE,ElementType.METHOD})
public @interface IPermiss {
    int age();
    int[] array();
}
