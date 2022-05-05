package com.utm.stadydatabase.fragments.addfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.utm.stadydatabase.REPOSITORY
import com.utm.stadydatabase.database.Menu
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddViewModel : ViewModel() {
    fun insert(menu: Menu, onSuccess:() -> Unit) =
        viewModelScope.launch (Dispatchers.IO){
            REPOSITORY.insertNote(menu){
                onSuccess()
            }
        }
}