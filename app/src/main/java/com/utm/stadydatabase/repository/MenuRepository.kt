package com.utm.stadydatabase.repository

import androidx.lifecycle.LiveData
import com.utm.stadydatabase.database.Menu

interface MenuRepository {
    val allNotes: LiveData<List<Menu>>
    suspend fun insertNote(menu: Menu, onSuccess:() -> Unit)
    suspend fun deleteNote(menu: Menu, onSuccess:() -> Unit)
}