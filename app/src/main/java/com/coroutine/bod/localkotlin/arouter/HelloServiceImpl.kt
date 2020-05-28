package com.coroutine.bod.localkotlin.arouter

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route

/**
 *
 * @ClassName: HelloServiceImpl
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-05-28
 */
@Route(path = "/app/hello",name = "Test Service")
class HelloServiceImpl:HelloService {

    override fun init(context: Context?) {
    }

    override fun sayHello(name: String): String {
        return "AAAAA $name"
    }

}