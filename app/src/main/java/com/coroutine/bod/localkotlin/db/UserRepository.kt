package com.coroutine.bod.localkotlin.db

import androidx.lifecycle.LiveData

/**
 *
 * @ClassName: UserRepository
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-04-02
 */
class UserRepository(private val userDao: UserDao) {

    val allUser = userDao.getAllUser()

     fun insert(user: User){
        userDao.insertUser(user)
    }

}