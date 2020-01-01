package com.coroutine.bod.localkotlin.test

import android.content.DialogInterface
import android.os.Bundle
import android.util.ArrayMap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coroutine.bod.localkotlin.FocusBaseFragment
import timber.log.Timber


/**
 * Created by 李林敏 on 2018/6/19.
 *
 * SupportFragment Life
 * onCreateView() -> onActivityCreated() -> onResume() -> onSupportVisible -> onLazyInitView() => onSupportInvisible() -> onPause()
 */
abstract class BaseFragment : FocusBaseFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(getLayoutId(), container, false)
    }

    abstract fun getLayoutId(): Int


    override fun onSupportVisible() {
        super.onSupportVisible()
        Timber.d("onSupportVisible:${this.javaClass.name}")
    }

}