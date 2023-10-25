package com.example.travel.db

import android.net.Uri
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "places")
class Place(
    @field:PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var date: Date,
    var description: String,
    var rating: Int,
    var photoUrl: Uri?
)