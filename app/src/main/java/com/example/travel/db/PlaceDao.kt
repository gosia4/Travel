package com.example.travel.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface PlaceDao {
    @Insert
    fun insert(place: Place): Long

    @Update
    fun update(place: Place)

    @Query("DELETE FROM places WHERE id = :id")
    fun delete(id: Int)
    abstract fun getPlaceById(placeId: Int): Place

    @Query("SELECT * FROM places")
    fun allPlaces(): LiveData<List<Place>>
}