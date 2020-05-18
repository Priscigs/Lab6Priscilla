package com.example.zvent3.guest

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.zvent3.database.Guest
import com.example.zvent3.database.ZventDatabaseDao

class GuestViewModel(val database: ZventDatabaseDao) : ViewModel() {

    private val guests = database.getGuest()

    private val guestText = Transformations.map(guests) {
        builGuestText(it)
    }

    fun builGuestText(guests: List<Guest>) : String {
        val guestText = StringBuilder()
        for (guest in guests) {
            guestText.append("Invitado: ${guest.guestId}\nNombre: ${guest.nameGuest}\nTeléfono: ${guest.email}\n\n")
        }
        return guestText.toString()
    }
}
