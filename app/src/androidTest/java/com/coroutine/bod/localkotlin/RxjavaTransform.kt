package com.coroutine.bod.localkotlin

import io.reactivex.*
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.functions.Function
import io.reactivex.internal.operators.observable.ObservableSubscribeOn
import org.junit.Test
import timber.log.Timber

/**
 * 变化形操作符
 * 在上游和下游之间做了变化
 */
class RxjavaTransform {
    @Test
    fun useAppContext() {
        //map
        Observable.just("123")
            .map {
                it.length
            }.subscribe {
                Timber.d("$it")
            }

        Observable.just(123456)
            .map { t -> "$t" }
            .map {
                it.length > 5
            }
            .subscribe {
                Timber.d("map:多次变化之后的类型：$it")
            }

        //flatMap 无序的
        Observable.just("1", "2", "3")
            .flatMap(Function<String, ObservableSource<Boolean>> {
                //因为Observable实现了 ObservableSource接口
                Observable.create { emitter ->
                    emitter.onNext(it == "2")
                }
            })
            .subscribe {
                Timber.d("Subscribe Result:$it")
            }


        //concatMap 有序的
        Observable.create<String> {
            it.onNext("自己发射自己")
            it.onNext("哈哈哈")
            it.onNext("嘿嘿嘿")
        }.subscribe {
            Timber.d("concatmap:$it")
        }

        //GroupBy
        Observable.just(1000,2000,3000)
            .groupBy {//分组变化操作符号
                if (it>1500) "高端配置" else "低端配置"
            }
            .subscribe { group ->
                group.key //但是这里只拿到了这个分组的依据key
                group.subscribe {
                    //GroupedObservable 这里拿到的还是一个GroupedObservable(继承了Observable)
                    Timber.d("拿到了分组的Key和类别: ${group.key} $it")

                }
            }

//        Observable.fromIterable(arrayListOf("1","2","3"))

        //buffer 分成两步进行发射

        val toList = (0 until 100).toList()
        toList.forEach { Timber.d("List: $it") }
//        Observable.create

        Observable.fromIterable((0 until 100).toList())
            .buffer(50)
            .subscribe {
                Timber.d("fromIterable:$it")
            }

    }
}

