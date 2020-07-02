package com.coroutine.bod.localkotlin.simple5

/**
 *
 * @ClassName: NetManager
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-06-16
 */
class NetManager {
    object Holder{
        val instance = NetManager()
    }

    //static 派生操作
    companion object{
        //静态修饰
        fun getInstance():NetManager = Holder.instance
    }

}