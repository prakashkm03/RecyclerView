package com.example.recyclerview

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row.view.*

class DataAdapter(private val exampleList: List<Model>, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<DataAdapter.Exampleviewholder>() {

    inner class Exampleviewholder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        val imageView: ImageView = itemView.image_view
        val textView1: TextView = itemView.text_view1
        val textView2: TextView = itemView.text_view2

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Exampleviewholder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)

        return Exampleviewholder(itemView)

    }

    override fun onBindViewHolder(holder: Exampleviewholder, position: Int) {

        val currentItem = exampleList[position]

        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2


    }

    override fun getItemCount(): Int {
        return exampleList.size

    }


}