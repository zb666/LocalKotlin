package com.coroutine.bod.localkotlin.helper

/**
 *
 * @ClassName: Helper
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-01-07
 */

class InitCLass(private var initName:String){

    private var local = "Local"

    init {
        var  test = "Test"
    }
}

class Sub constructor(var subName: String )
    :Parent(name = "SubName"){

    init {
        subName = "TestName"
    }
}


open class Parent(val name:String){

}