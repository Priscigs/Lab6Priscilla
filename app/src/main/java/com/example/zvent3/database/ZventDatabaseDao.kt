package com.example.zvent3.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ZventDatabaseDao {

    @Insert
    fun insert(guest: Guest)

    @Update
    fun update(guest: Guest)

    @Query("SELECT * FROM guest_table WHERE guestId = :key")
    fun getGuest(key: Long): Guest?

    @Query("SELECT * FROM guest_table")
    fun getGuest() : LiveData<List<Guest>>
}