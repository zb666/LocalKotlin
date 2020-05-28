package com.coroutine.bod.localkotlin.api

import androidx.lifecycle.LiveData
import retrofit2.http.GET

/**
 *
 * @ClassName: GitHubService
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-05-23
 */
interface GitHubService {

    @GET("1")
    fun getUser():String

}