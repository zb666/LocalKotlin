package com.coroutine.bod.localkotlin.arouter

import com.alibaba.android.arouter.facade.template.IProvider

/**
 * @ClassName: HelloService
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-05-28
 */
interface HelloService : IProvider {
    fun sayHello(name: String): String
}
