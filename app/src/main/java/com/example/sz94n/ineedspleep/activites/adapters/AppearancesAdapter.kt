package com.example.sz94n.ineedspleep.activites.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sz94n.ineedspleep.R
import com.example.sz94n.ineedspleep.activites.models.character.CharactersAppearances
import kotlinx.android.synthetic.main.item_names.view.*

class AppearancesAdapter(val appearancesList: List<CharactersAppearances>) :
    RecyclerView.Adapter<AppearancesAdapter.AppearancesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppearancesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_names, parent, false)
        return AppearancesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return appearancesList.size
    }

    override fun onBindViewHolder(viewHolder: AppearancesViewHolder, position: Int) {
        viewHolder.setAnime(appearancesList[position])
    }

    inner class AppearancesViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun setAnime(anime: CharactersAppearances) {

            view.namesTextView.text = anime.name
        }

    }


}