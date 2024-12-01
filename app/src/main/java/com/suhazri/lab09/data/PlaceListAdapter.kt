package com.suhazri.lab09.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.suhazri.lab09.R
import com.suhazri.lab09.model.Place

//Step 21 () -> Passed as argument
//To use a RecyclerView, we need an adapter
//An adapter is a link between the data set (ArrayList<List>) and the UI (RecyclerView)
//To create an adapter, we need to implement RecyclerView.Adapter (Adapter)
//We need to implement 3 methods: onCreateViewHolder, getItemCount, onBindViewHolder
class PlaceListAdapter(private val list: ArrayList<Place>, private val context: Context)
    : RecyclerView.Adapter<PlaceListAdapter.ViewHolder>() {

    //Step 27
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    //Step 29: which xml file used to show the ViewHolder -> custom_row.xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.custom_row, parent, false)
        return ViewHolder(view)
    }

    //Step 28: How many row to show in the RecyclerView
    override fun getItemCount(): Int {
        return list.size
    }

    //Step 30 & 31: What to show in customRow -> titleTextView, subtitleTextView
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var countryTextView: TextView = holder.itemView.findViewById(R.id.itemTextView)
        var cityTextView: TextView = holder.itemView.findViewById(R.id.subtitleTextView)

        countryTextView.text = list[position].countryName
        cityTextView.text = list[position].cityName
    }

}