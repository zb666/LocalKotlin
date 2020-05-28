package com.coroutine.bod.localkotlin.db

import androidx.lifecycle.LiveData
import com.coroutine.bod.localkotlin.api.GitHubService

/**
 *
 * @ClassName: UserRepository
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-04-02
 */
class UserRepository(private val userDao: UserDao,private val gitHubService: GitHubService) {

    val allUser = userDao.getAllUser()

    fun insert(user: User) {
        userDao.insertUser(user)
    }

    fun getUserLiveData() = gitHubService.getUser()

}