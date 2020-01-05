package com.coroutine.bod.localkotlin.handle

/**
 *
 * @ClassName: BobMessafge
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-01-05
 */
class BobMessage {
    private var obj:String=""
    lateinit var target:BobHandler

    constructor(obj: String) {
        this.obj = obj
    }
}