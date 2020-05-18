package com.example.zvent3.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "guest_table")
class Guest(
    @PrimaryKey(autoGenerate = true)
    var guestId: Long = 0L,

    val nameGuest: String,

    val phone: String,

    val email: String
)
