package com.utm.stadydatabase.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MenuDao {
    @Query("SELECT * FROM menu123")
    fun getAllNotes(): LiveData<List<Menu>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(menu: Menu)
    
    @Update
    fun update(menu: Menu)

    @Delete
    fun delete(user: Menu)
}