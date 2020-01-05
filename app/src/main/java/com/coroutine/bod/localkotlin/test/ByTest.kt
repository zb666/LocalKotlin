package com.coroutine.bod.localkotlin.test

import test.BackFmActivity
import kotlin.reflect.KProperty

/**
 *
 * @ClassName: ByTest
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-01-03
 */
class ByTest {
    operator fun getValue(backFmActivity: BackFmActivity, property: KProperty<*>): String {
        return "ByTest"
    }

    operator fun setValue(backFmActivity: BackFmActivity, property: KProperty<*>, s: String) {

    }
}