package com.coroutine.bod.localkotlin.db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 *
 * @ClassName: UserAppViewModel
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-04-02
 */
class UserAppViewModel(app:Application):AndroidViewModel(app) {

    private lateinit var repository:UserRepository


    init {
        //database->dao->user
        val userDao = AppDataBase.getDataBase(app).userBean()
//        repository = UserRepository(userDao)
    }

    fun insert(user: User){
        viewModelScope.launch {
            repository.insert(user)
        }
    }

    suspend fun selectAll()= withContext(Dispatchers.IO){
        repository.allUser
    }
}