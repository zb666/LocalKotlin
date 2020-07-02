package com.coroutine.bod.localkotlin.fragment

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenCreated
import androidx.lifecycle.whenResumed
import androidx.lifecycle.whenStarted
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.internal.operators.observable.ObservableCreate
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayDeque

/**
 *
 * @ClassName: DemoFragment
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-06-18
 */
class DemoFragment:Fragment() {

    private val queue = java.util.ArrayDeque<Runnable>()

    init {
        Observable.just("1")
            .map {
                it.hashCode()
            }.subscribe {

            }

        queue.add(Runnable {
            Thread.sleep(1000)
        })
        queue.poll().run()
        lifecycleScope.launch {
            whenCreated {

            }
            whenStarted {

            }
            whenResumed {

            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Observable.create(ObservableOnSubscribe<String> {

        })
            .subscribeOn(Schedulers.newThread())
            .observeOn(Schedulers.computation())
            .subscribe {

            }
    }
}