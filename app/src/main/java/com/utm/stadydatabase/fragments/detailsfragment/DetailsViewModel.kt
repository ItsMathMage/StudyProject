package com.utm.stadydatabase.fragments.detailsfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.utm.stadydatabase.REPOSITORY
import com.utm.stadydatabase.database.Menu
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsViewModel : ViewModel() {
    fun delete(menu: Menu, onSuccess:() -> Unit) =
        viewModelScope.launch (Dispatchers.IO){
            REPOSITORY.deleteNote(menu){
                onSuccess()
            }
        }
}