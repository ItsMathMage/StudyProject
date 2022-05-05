package com.utm.stadydatabase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Menu::class), version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun menuDao(): MenuDao

    companion object{
        private var database: AppDataBase ?= null

        @Synchronized
        fun getInstance(context: Context): AppDataBase{
            return if (database == null){
                database = Room.databaseBuilder(context, AppDataBase::class.java, "db").build()
                database as AppDataBase
            } else {
                database as AppDataBase;
            }
        }
    }
}