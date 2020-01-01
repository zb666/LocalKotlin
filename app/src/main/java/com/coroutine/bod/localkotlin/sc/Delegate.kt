package com.coroutine.bod.localkotlin.sc

import kotlin.reflect.KProperty

/**
 *
 * @ClassName: Delegate
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-01-01
 */
class Delegate {

    operator fun getValue(thisRef:Any?,property:KProperty<*>):String{
        return "this Ref :$thisRef  this KProperty${property.run { 
            "$returnType $name $parameters $isOpen"
        }}"
    }
}