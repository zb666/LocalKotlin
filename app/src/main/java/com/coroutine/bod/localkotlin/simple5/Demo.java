package com.coroutine.bod.localkotlin.simple5;

import timber.log.Timber;

/**
 * @ClassName: Demo
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-06-16
 */

public enum Demo {
    INSTANCE;

    void testDemo(){
        Timber.d("Demo: "+hashCode());
    }
}
