//package com.example.travel
//
//import android.app.Activity
//import android.content.Intent
//import android.net.Uri
//import android.os.Bundle
//import android.provider.MediaStore
//import android.view.View
//import android.widget.Button
//import android.widget.EditText
//import android.widget.RatingBar
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import com.example.travel.db.AppDatabase
//import com.example.travel.db.Place
//
//class AddPlaceActivity : AppCompatActivity() {
//    var name: EditText? = null
//    var date:EditText? = null
//    var description:EditText? = null
//    private val RESULT_LOAD_IMAGE = 1
//    private val selectedImageUri: Uri? = null
//    var ratingBar: RatingBar? = null
//    var savePlace: Button? = null
//    var cancel: Button? = null
//    var place: Place? = null
//    private lateinit var database: AppDatabase
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_add_place)
//        database = AppDatabase.getInstance(this)!!
//
//        // Handle the "Add" button click to add a new place
//        val addButton = findViewById<Button>(R.id.saveButton)
//
//        name = findViewById<EditText>(R.id.nameEditText)
//        date = findViewById<EditText>(R.id.dateEditText)
//        description = findViewById<EditText>(R.id.descriptionEditText)
//        ratingBar = findViewById(R.id.ratingBar)
//
//        val intent = intent
//
//        cancel?.setOnClickListener(View.OnClickListener {
//            val intent = Intent(applicationContext, PlaceAdapter::class.java)
//            startActivity(intent)
//        })
//        val selectImageButton = findViewById<Button>(R.id.photoButton)
//        selectImageButton.setOnClickListener { // Launch an intent to pick an image from the gallery
//            val galleryIntent = Intent(
//                Intent.ACTION_PICK,
//                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
//            )
//            startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE)
//        }
//
//        addButton.setOnClickListener {
//            val placeName = name.getText().toString()
//            val dateOfVisit = date.
//            val desc = description.getText().toString()
//            val rating = ratingBar.getRating()
//            // Create a new Place object
//            val newPlace = Place(placeId, placeName, dateOfVisit, desc, rating, null)
//
//            // Insert the new place into the database
//            val placeId = database.placeDao()?.insert(newPlace)
//
//            if (placeId != null) {
//                Toast.makeText(this, "Place added!", Toast.LENGTH_SHORT).show()
//                // Set the result and finish the activity
//                setResult(Activity.RESULT_OK)
//                finish()
//            } else {
//                Toast.makeText(this, "Failed to add place", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//}