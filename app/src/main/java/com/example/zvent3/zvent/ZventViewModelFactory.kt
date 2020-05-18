package com.example.zvent3.zvent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.zvent3.database.ZventDatabaseDao

class ZventViewModelFactory(private val database: ZventDatabaseDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ZventViewModel::class.java)) {
            return ZventViewModel(database) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}