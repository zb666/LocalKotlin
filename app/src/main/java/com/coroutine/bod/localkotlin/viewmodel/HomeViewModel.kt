package com.coroutine.bod.localkotlin.viewmodel

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 *
 * @ClassName: HomeViewModel
 * @Description:
 * @Author: zb666
 * @CreateDate: 2019-09-29
 */
class HomeViewModel:ViewModel() {

    private val a by lazy { "" }

    private val _homeLiveData = MutableLiveData<String>()
    val homeLiveData = _homeLiveData

    val curLiveDat:LiveData<String> = liveData {
        emit(addData())
    }

   private suspend fun addData():String = withContext(Dispatchers.IO){
        "Data Resource"
    }

    fun getHomeData() {
        viewModelScope.launch {
            delay(1000)
            _homeLiveData.value = "Home Result"
        }
    }

}