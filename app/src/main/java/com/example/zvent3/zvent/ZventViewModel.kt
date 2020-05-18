package com.example.zvent3.zvent

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.zvent3.data.Guest
import com.example.zvent3.database.ZventDatabaseDao

class ZventViewModel(database: ZventDatabaseDao) : ViewModel() {
    val guest = MutableLiveData<Guest>()

    fun updateGuest(guest: Guest) {
        this.guest.value = guest
    }
}
