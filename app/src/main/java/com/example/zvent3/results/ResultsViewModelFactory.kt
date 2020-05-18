package com.example.zvent3.results

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.zvent3.data.Guest

class ResultsViewModelFactory(private val guests: MutableList<Guest>) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ResultsViewModel::class.java)) {
            return ResultsViewModel(guests) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}