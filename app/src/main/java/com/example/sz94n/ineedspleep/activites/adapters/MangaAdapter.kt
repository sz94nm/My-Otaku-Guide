package com.example.sz94n.ineedspleep.activites.adapters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sz94n.ineedspleep.R
import com.example.sz94n.ineedspleep.activites.activities.MangaInfoActivity
import com.example.sz94n.ineedspleep.activites.models.manga.Manga
import com.example.sz94n.myanimeguide.junk.Consts
import com.example.sz94n.myanimeguide.junk.loadImageFromURL
import kotlinx.android.synthetic.main.item.view.*

class MangaAdapter(val mangaList: List<Manga>) : RecyclerView.Adapter<MangaAdapter.MangaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MangaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mangaList.size
    }

    override fun onBindViewHolder(viewHolder: MangaViewHolder, position: Int) {
        viewHolder.setManga(mangaList[position])
    }


    inner class MangaViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        init {
            view.setOnClickListener {


                val intent = Intent(it.context, MangaInfoActivity::class.java)
                val putExtra = intent.putExtra(Consts.MANGA_KEY, mangaList[layoutPosition])
                it.context.startActivity(intent)

            }
        }

        fun setManga(manga: Manga) {

            view.itemTitleTextView.text = manga.title
            view.itemPosterImageView.loadImageFromURL(manga.imageUrl)
        }

    }
}
