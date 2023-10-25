//package com.example.travel
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.example.travel.db.Place
//
//class PlaceAdapter(private val context: Context, private val places: List<Place>) :
//    RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder>() {
//
//    private var itemClickListener: OnItemClickListener? = null
//
//    // Define the interface for item click events
//    interface OnItemClickListener {
//        fun onItemClick(position: Int)
//    }
//
//    // Setter method for the item click listener
//    fun setOnItemClickListener(listener: OnItemClickListener) {
//        itemClickListener = listener
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
//        val view: View = LayoutInflater.from(context).inflate(R.layout.list_item_place, parent, false)
//        return PlaceViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
//        val place = places[position]
//        holder.nameTextView.text = place.name
//        holder.dateTextView.text = place.date.toString()
//        holder.descriptionTextView.text = place.description
//        holder.ratingTextView.text = place.rating.toString()
//
//        val picasso = Picasso.get()
//
//        if (place.photoUrl != null) {
//            picasso.load(place.photoUrl.toString()).into(holder.photoImageView)
//        } else {
//            picasso.load(R.drawable.placeholder_image).into(holder.photoImageView)
//        }
//
//        // Handle item click event
//        holder.itemView.setOnClickListener {
//            itemClickListener?.onItemClick(position)
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return places.size
//    }
//
//    inner class PlaceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
//        val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)
//        val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
//        val ratingTextView: TextView = itemView.findViewById(R.id.ratingTextView)
//        val photoImageView: ImageView = itemView.findViewById(R.id.photoImageView)
//    }
//}
