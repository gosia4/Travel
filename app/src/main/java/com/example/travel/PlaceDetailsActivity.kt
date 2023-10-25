//package com.example.travel
//
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import android.widget.RatingBar
//import androidx.appcompat.app.AppCompatActivity
//import com.example.travel.db.Place
//
//class PlaceDetailsActivity : AppCompatActivity() {
//    private lateinit var place: Place
//    var name: EditText? = null
//    var date:EditText? = null
//    var description:EditText? = null
//    private val RESULT_LOAD_IMAGE = 1
//    var ratingBar: RatingBar? = null
//    var updateButton: Button? = null
//    var cancel: Button? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_place_details)
//        name = findViewById<EditText>(R.id.nameEditText)
//        date = findViewById<EditText>(R.id.dateEditText)
//        description = findViewById<EditText>(R.id.descriptionEditText)
//        ratingBar = findViewById(R.id.ratingBar)
//        cancel = findViewById<Button>(R.id.cancelButton)
//
//        // Populate the UI fields with place details
//        nameEditText.setText(place.name)
//        // Set other UI fields
//
//        // Handle the Save button
//        updateButton.setOnClickListener {
//            // Update the place object with user inputs
//            place.name = nameEditText.text.toString()
//            // Set other place attributes
//
//            // Handle saving or updating the place in your database
//
//            // Finish the activity or perform any necessary actions
//            finish()
//        }
//
//        // Handle the Cancel button
//        cancelButton.setOnClickListener {
//            // Finish the activity or perform any necessary actions
//            finish()
//        }
//    }
//}
