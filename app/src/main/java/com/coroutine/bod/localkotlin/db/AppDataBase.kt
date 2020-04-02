package com.coroutine.bod.localkotlin.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 *
 * @ClassName: AppDataBase
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-04-02
 */
@Database(entities = [User::class],version = 1,exportSchema = false)
//必须为abs 且继承RomDatabase
abstract class AppDataBase:RoomDatabase() {
    abstract fun userBean():UserDao

    companion object{
        @Volatile
        private var instance:AppDataBase?=null
        fun getDataBase(context: Context):AppDataBase{
            return instance?: synchronized(this){
                val ins =
                    Room.databaseBuilder(context.applicationContext,
                        AppDataBase::class.java,"user_database.db")
                    .build()
                instance = ins
                ins
            }
        }
    }
}