package vn.edu.hust.bai3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import vn.edu.hust.bai3.R
import vn.edu.hust.bai3.model.AppItem

class RecommendedAppAdapter(
    private val items: List<AppItem>
) : RecyclerView.Adapter<RecommendedAppAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvCategory: TextView? = view.findViewById(R.id.tvCategory)
        val imgIcon: ImageView = view.findViewById(R.id.imgIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_horizontal_app, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.tvName.text = item.name
        holder.tvCategory?.text = item.genre
        holder.imgIcon.setImageResource(item.imageRes)
    }

    override fun getItemCount() = items.size
}

