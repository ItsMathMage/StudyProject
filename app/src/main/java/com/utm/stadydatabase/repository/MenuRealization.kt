package com.utm.stadydatabase.repository

import androidx.lifecycle.LiveData
import com.utm.stadydatabase.database.Menu
import com.utm.stadydatabase.database.MenuDao

class MenuRealization(private val menuDao: MenuDao) : MenuRepository {
    override val allNotes: LiveData<List<Menu>> = menuDao.getAllNotes()

    override suspend fun insertNote(menu: Menu, onSuccess: () -> Unit) {
        menuDao.insert(menu)
        onSuccess()
    }

    override suspend fun deleteNote(menu: Menu, onSuccess: () -> Unit) {
        menuDao.delete(menu)
        onSuccess()
    }
}