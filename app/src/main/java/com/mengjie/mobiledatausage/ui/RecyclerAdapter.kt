package com.mengjie.mobiledatausage.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.mengjie.mobiledatausage.R
import com.mengjie.mobiledatausage.data.MobileDataItem
import kotlinx.android.synthetic.main.list_item_view.view.*

class RecyclerAdapter(
    private val context: Context,
    private val item: List<MobileDataItem>
) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.quarter.text = item[position].year
        holder.amount.text = item[position].totalUsage
        holder.image.setImageDrawable(context.getDrawable(R.mipmap.ic_launcher))
        holder.image.setOnClickListener {
            Toast.makeText(context, "Image is clicked", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.list_item_view,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return item.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val quarter: TextView = view.quarter_view
        val amount: TextView = view.amount_view
        val image: ImageView = view.image_view
    }
}