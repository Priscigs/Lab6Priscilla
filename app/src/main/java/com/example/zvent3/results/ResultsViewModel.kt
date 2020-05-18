package com.example.zvent3.results

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.zvent3.data.Guest

class ResultsViewModel(guests: MutableList<Guest>) : ViewModel() {
    private val _guestCount = MutableLiveData<Int>()
    val guestCount: LiveData<Int>
        get() = _guestCount

    private val _resultsText = MutableLiveData<String>()
    val resultsText: LiveData<String>
        get() = _resultsText

    init {
        _guestCount.value = guests.size
        for (guest in guests){
            _resultsText.value += "${guest.name} : ${guest.phone} : ${guest.email}\n"
        }
    }
}
