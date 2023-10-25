package com.example.travel

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
//import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.travel.db.AppDatabase
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupActionBarWithNavController(findNavController(R.id.fragment))
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var placeAdapter: PlaceAdapter
//    private lateinit var database: AppDatabase
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        recyclerView = findViewById(R.id.recyclerView)
//        placeAdapter = PlaceAdapter(this, emptyList()) // Initially, the list is empty
//
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = placeAdapter
//
//        database = AppDatabase.getInstance(this)!!
//
//        // Handle item click events
//        placeAdapter.setOnItemClickListener(object : PlaceAdapter.OnItemClickListener {
//            override fun onItemClick(position: Int) {
//                val selectedPlace = placeAdapter.getItem(position)
//                if (selectedPlace != null) {
//                    // Launch an activity to view/edit the selected place
//                    val intent = Intent(this@MainActivity, ViewEditPlaceActivity::class.java)
//                    intent.putExtra("PLACE_ID", selectedPlace.id)
//                    startActivity(intent)
//                }
//            }
//        })
//
//        // Add a new place button click
//        val addButton = findViewById<Button>(R.id.btnAddPlace)
//        addButton.setOnClickListener {
//            val intent = Intent(this, AddPlaceActivity::class.java)
//            startActivityForResult(intent, ADD_PLACE_REQUEST)
//        }
//    }
//
//    // Handle the result of adding a new place
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == ADD_PLACE_REQUEST && resultCode == Activity.RESULT_OK) {
//            // Refresh the list of places
//            val places = database.placeDao()?.allPlaces
//            placeAdapter.setPlaces(places ?: emptyList())
//            placeAdapter.notifyDataSetChanged()
//        }
//    }
}
