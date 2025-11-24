package vn.edu.hust.bai3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import vn.edu.hust.bai3.R
import vn.edu.hust.bai3.model.AppItem

class SponsoredAppAdapter(
    private val items: List<AppItem>
) : RecyclerView.Adapter<SponsoredAppAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvGenre: TextView = view.findViewById(R.id.tvGenre)
        val tvRating: TextView = view.findViewById(R.id.tvRating)
        val tvSize: TextView = view.findViewById(R.id.tvSize)
        val imgIcon: ImageView = view.findViewById(R.id.imgIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_grid_app, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.tvName.text = item.name
        holder.tvGenre.text = item.genre
        holder.tvRating.text = item.rating
        holder.tvSize.text = item.size
        holder.imgIcon.setImageResource(item.imageRes)
    }

    override fun getItemCount() = items.size
}

