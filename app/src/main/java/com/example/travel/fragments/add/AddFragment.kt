package com.example.travel.fragments.add

import android.content.Intent
import android.media.Rating
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.travel.R
import com.example.travel.db.Place
import com.example.travel.db.PlaceViewModel
import java.text.SimpleDateFormat
import java.util.Date

class AddFragment : Fragment() {
    private lateinit var mPlaceViewModel: PlaceViewModel
    private lateinit var galleryLauncher: ActivityResultLauncher<String>
    private var selectedPhotoUri: Uri? = null

    private lateinit var binding: FragmentAddBinding // View Binding instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the launcher for picking an image from the gallery
        galleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            if (uri != null) {
                selectedPhotoUri = uri
                // You can update your UI or take any necessary action here
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Initialize View Binding
        binding = FragmentAddBinding.inflate(inflater, container, false)
        val view = binding.root // Access the root view of the binding

        mPlaceViewModel = ViewModelProvider(this).get(PlaceViewModel::class.java)

        val buttonAddPhoto = view.findViewById<Button>(R.id.buttonAddPhoto)

        buttonAddPhoto.setOnClickListener {
            // Use the galleryLauncher to open the gallery for photo selection
            galleryLauncher.launch("image/*")
        }

        view.add_btn.setOnClickListener {
            insertDataToDatabase()
        }

        return view // Return the root view with View Binding
    }

    private fun insertDataToDatabase() {
        val name = binding.placeName.text.toString()
        val description = binding.description.text.toString()
        val cos = binding.editTextDate.text.toString()
        val date = SimpleDateFormat("yyyy-MM-dd").parse(cos)
        val rating = binding.ratingBar2.rating // Use rating from RatingBar
        val photoUri = selectedPhotoUri

        if (inputCheck(name, date, description, rating, photoUri)) {
            val place = Place(0, name, date, description, rating, photoUri)
            // Add Data to Database
            mPlaceViewModel.addPlace(place)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
            // Navigate Back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(name: String, date: Date, description: String, rating: Float, photo: Uri?): Boolean {
        val ratingText = rating.toString()
        return !(TextUtils.isEmpty(name) || date == null || TextUtils.isEmpty(description) || TextUtils.isEmpty(ratingText))
    }
}
