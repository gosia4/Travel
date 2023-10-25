//package com.example.travel
//
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import com.example.travel.db.AppDatabase
//
//class ViewPlaceActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_view_place)
//
//        // Retrieve the place ID passed from the main activity
//        val placeId = intent.getIntExtra("PLACE_ID", -1)
//
//        // Load and display the details of the place with ID=placeId from the database
//        val placeDao = AppDatabase.getInstance(this)?.placeDao()
//        val place = placeDao?.getPlaceById(placeId)
//
//        // Initialize views and widgets in the layout with place details
//    }
//}
