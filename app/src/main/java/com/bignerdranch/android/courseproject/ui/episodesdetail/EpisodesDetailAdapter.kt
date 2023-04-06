package com.bignerdranch.android.courseproject.ui.episodesdetail

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.courseproject.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bignerdranch.android.courseproject.data.entities.Character
import com.bignerdranch.android.courseproject.data.entities.Episodes
import com.bignerdranch.android.courseproject.databinding.ItemCharacterBinding

class EpisodesDetailAdapter(private val characters: List<String>) :
    RecyclerView.Adapter<EpisodesDetailAdapter.ResidentViewHolder>() {

    class ResidentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val residentNameTextView: TextView = view.findViewById(R.id.name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResidentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)
        return ResidentViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResidentViewHolder, position: Int) {
        val residentName = characters[position]
        holder.residentNameTextView.text = residentName
    }

    override fun getItemCount(): Int {
        return characters.size
    }
}