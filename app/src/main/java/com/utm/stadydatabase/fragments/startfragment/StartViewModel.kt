package com.utm.stadydatabase.fragments.startfragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.utm.stadydatabase.REPOSITORY
import com.utm.stadydatabase.database.AppDataBase
import com.utm.stadydatabase.database.Menu
import com.utm.stadydatabase.repository.MenuRealization
import com.utm.stadydatabase.repository.MenuRepository

class StartViewModel(application: Application) : AndroidViewModel(application) {

    val context = application

    fun initDatabase(){
        val daoNote = AppDataBase.getInstance(context).menuDao()
        REPOSITORY = MenuRealization(daoNote)

    }

    fun getAllNotes(): LiveData<List<Menu>> {
        return REPOSITORY.allNotes
    }
}