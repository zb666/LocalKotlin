package com.coroutine.bod.localkotlin.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coroutine.bod.localkotlin.db.User
import com.coroutine.bod.localkotlin.db.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

/**
 *
 * @ClassName: UserViewModel
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-05-23
 */
class UserViewModel(private val repository: UserRepository) : ViewModel() {

    private val _liveData = MediatorLiveData<String>()
    val liveData: LiveData<String> = _liveData

    suspend fun getUserLiveData() = withContext(Dispatchers.IO){
        viewModelScope.launch {
            try {
                _liveData.value = repository.getUserLiveData()
            }catch (e:Exception){

            }finally {
                //do nothing
            }
        }
    }

}