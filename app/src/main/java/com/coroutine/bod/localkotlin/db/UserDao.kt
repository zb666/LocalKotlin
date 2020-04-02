package com.coroutine.bod.localkotlin.db

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 *
 * @ClassName: UserDao
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-04-02
 */

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Delete
    fun deleteShoes(userList: List<User>)

    @Query("SELECT * FROM user_name_table")
    fun getAllUser(): List<User>
}