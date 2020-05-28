package com.coroutine.bod.localkotlin.jetpackdemo.test

import androidx.lifecycle.*
import kotlinx.coroutines.*

/**
 *
 * @ClassName: TestViewModel
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-04-27
 */
class TestViewModel : ViewModel() {
    private val loginData = MutableLiveData<String>()

    val result = loginData.switchMap {
        liveData { emit(it.hashCode()) } //将数据转化
    }

    private val sss by lazy {
        "DemoStr"
    }

    init {
        viewModelScope.launch {
         //start
            delay(1000)
            loginData.postValue("aaaaa")
        }
    }


    fun addData(){

    }
    private val testRepository = TestRepository()

    fun getData() {
        val let = "str".let {
            123
        }
        //扩展函数，返回this
        val apply = "str".apply {

        }

        //T的扩展函数，返回的是Lamder，lamder最后一行就是返回的值
        111.let {

        }

        val with = with("str") {
        }

//        CoroutineScope(SupervisorJob()+Dispatchers.IO)

        loginData.value = testRepository.getData()
    }


}