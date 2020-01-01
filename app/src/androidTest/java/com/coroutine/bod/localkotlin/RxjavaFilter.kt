package com.coroutine.bod.localkotlin

import io.reactivex.Observable
import io.reactivex.functions.Consumer
import org.junit.Test
import timber.log.Timber

/**
 *
 * @ClassName: RxjavaFilter
 * @Description:
 * @Author: zb666
 * @CreateDate: 2019-10-20
 */
class RxjavaFilter {

    @Test
    fun userFunTest(){

        Observable.just("1","2","3")
            .filter {
                it == "2"
            }.subscribe {
                Timber.d("Filter: $it")
            }

        //取前多少项
        Observable.fromIterable((0 until 10).toList())
            .take(4)
            .subscribe {
                Timber.d("take: $it")
            }


        Observable.just("1","2","2")
            .distinct()
            .subscribe {
                Timber.d("Distinct: $it")
            }

        Observable.fromIterable((0 until 10).toList())
            .elementAt(1,123) //过滤指定位置的下标
            .subscribe(Consumer {
                Timber.d("elementAt: $it")
            })
    }
}