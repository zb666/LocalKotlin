package com.coroutine.bod.localkotlin.db

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 *
 * @ClassName: User
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-04-02
 */
@Entity(tableName = "user_name_table")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Long = 1,
    @ColumnInfo(name = "user_name") val name: String,
    @ColumnInfo(name = "user_sex") val sex: String
)


