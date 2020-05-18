package com.example.zvent3.guest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.zvent3.database.ZventDatabaseDao

class GuestViewModelFactory(private val database: ZventDatabaseDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GuestViewModel::class.java)) {
            return GuestViewModel(database) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}