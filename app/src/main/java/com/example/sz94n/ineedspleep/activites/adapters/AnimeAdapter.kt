package com.example.sz94n.ineedspleep.activites.adapters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sz94n.ineedspleep.R
import com.example.sz94n.ineedspleep.activites.activities.AnimeInfoActivity
import com.example.sz94n.ineedspleep.activites.models.anime.Anime
import com.example.sz94n.myanimeguide.junk.Consts
import com.example.sz94n.myanimeguide.junk.loadImageFromURL
import kotlinx.android.synthetic.main.item.view.*

class AnimeAdapter(val animeList: List<Anime>) : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return AnimeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return animeList.size
    }

    override fun onBindViewHolder(viewHolder: AnimeViewHolder, position: Int) {
        viewHolder.setAnime(animeList[position])
    }


    inner class AnimeViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        init {
            view.setOnClickListener {

                // val id = animeList[layoutPosition].malId

                val intent = Intent(it.context, AnimeInfoActivity::class.java)
                intent.putExtra(Consts.ANIME_KEY, animeList[layoutPosition])

                it.context.startActivity(intent)

            }
        }

        fun setAnime(anime: Anime) {

            view.itemTitleTextView.text = anime.title

            if (anime.imageUrl.isNotEmpty()) {
                view.itemPosterImageView.loadImageFromURL(anime.imageUrl)

            }
        }

    }
}

