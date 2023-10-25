package com.example.travel.db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlaceViewModel(application: Application):AndroidViewModel(application) {
    private val allPlaces: LiveData<List<Place>>
    private val repository: PlaceRepository

    init {
        val placeDao  = AppDatabase.getInstance(application)!!.placeDao()
        repository = PlaceRepository(placeDao!!)
        allPlaces = repository.allPlaces
    }

    fun addPlace(place: Place){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addPlace(place)
        }
    }
}


