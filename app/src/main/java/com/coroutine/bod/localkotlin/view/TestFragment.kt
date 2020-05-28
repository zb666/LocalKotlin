package com.coroutine.bod.localkotlin.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.coroutine.bod.localkotlin.api.UserViewModel

/**
 *
 * @ClassName: TestFragment
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-05-23
 */

class TestFragment:Fragment(){

    private lateinit var viewModel:UserViewModel

    init {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.liveData.observe(this, Observer {

        })


    }
}
