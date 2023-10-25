//package com.example.travel
//
//import android.content.Intent
//import android.os.Bundle
//import android.widget.Button
//import androidx.appcompat.app.AppCompatActivity
//import com.example.travel.db.AppDatabase
//
//class EditPlaceActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_edit_place)
//
//        // Retrieve the place ID passed from the main activity
//        val placeId = intent.getIntExtra("PLACE_ID", -1)
//
//        // Load the details of the place with ID=placeId from the database
//        val placeDao = AppDatabase.getInstance(this)?.placeDao()
//        val place = placeDao?.getPlaceById(placeId)
//
//        // Initialize views and widgets in the layout with place details
//
//        // Handle user input and update the place in the database
//        val updateButton = findViewById<Button>(R.id.updateButton)
//        updateButton.setOnClickListener {
//            // Retrieve user input
//            val updatedName = // Get updated name from input field
//            val updatedDate = // Get updated date from input field
//            val updatedDescription = // Get updated description from input field
//            val updatedRating = // Get updated rating from input field
//
//                // Update the place in the database using PlaceDao
//                place?.apply {
//                    name = updatedName
//                    date = updatedDate
//                    description = updatedDescription
//                    rating = updatedRating
//                    // Update other fields as needed
//                }
//            placeDao?.update(place)
//
//            // Navigate back to the main activity
//            startActivity(Intent(this, MainActivity::class.java))
//        }
//    }
//}
