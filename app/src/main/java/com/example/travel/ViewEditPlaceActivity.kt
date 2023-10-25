//package com.example.travel
//
//import android.app.Activity
//import android.content.Intent
//import android.os.Bundle
//import android.widget.Button
//import android.widget.ImageView
//import android.widget.TextView
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import com.example.travel.db.AppDatabase
//import com.example.travel.db.Place
//class ViewEditPlaceActivity : AppCompatActivity() {
//    private lateinit var database: AppDatabase
//    private lateinit var place: Place
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_view_edit_place)
//
//        val placeId = intent.getIntExtra("PLACE_ID", -1)
//        if (placeId == -1) {
//            // Handle invalid place ID
//            finish()
//        }
//
//        database = AppDatabase.getInstance(this)
//        place = database.placeDao()?.getPlace(placeId) ?: return
//
//        val nameTextView = findViewById<TextView>(R.id.nameTextView)
//        val dateTextView = findViewById<TextView>(R.id.dateTextView)
//        val descriptionTextView = findViewById<TextView>(R.id.descriptionTextView)
//        val ratingTextView = findViewById<TextView>(R.id.ratingTextView)
//
//        nameTextView.text = place.name
//        dateTextView.text = place.date.toString()
//        descriptionTextView.text = place.description
//        ratingTextView.text = place.rating.toString()
//
//        // Load and display the photo using Picasso
//        if (place.photoUrl != null) {
//            val photoImageView = findViewById<ImageView>(R.id.photoImageView)
//            Picasso.get().load(place.photoUrl.toString()).into(photoImageView)
//        }
//
//        // Handle edit button click
//        val editButton = findViewById<Button>(R.id.editButton)
//        editButton.setOnClickListener {
//            val intent = Intent(this, EditPlaceActivity::class.java)
//            intent.putExtra("PLACE_ID", place.id)
//            startActivityForResult(intent, EDIT_PLACE_REQUEST)
//        }
//
//        // Handle delete button click
//        val deleteButton = findViewById<Button>(R.id.deleteButton)
//        deleteButton.setOnClickListener {
//            // Delete the place from the database
//            database.placeDao()?.delete(place.id)
//            Toast.makeText(this, "Place deleted!", Toast.LENGTH_SHORT).show()
//
//            // Set the result and finish the activity
//            setResult(Activity.RESULT_OK)
//            finish()
//        }
//    }
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == EDIT_PLACE_REQUEST && resultCode == Activity.RESULT_OK) {
//            // Refresh the place data after editing
//            place = database.placeDao()?.getPlace(place.id) ?: return
//            val descriptionTextView = findViewById<TextView>(R.id.descriptionTextView)
//            val ratingTextView = findViewById<TextView>(R.id.ratingTextView)
//            descriptionTextView.text = place.description
//            ratingTextView.text = place.rating.toString()
//        }
//    }
//
//    companion object {
//        private const val EDIT_PLACE_REQUEST = 1
//    }
//}