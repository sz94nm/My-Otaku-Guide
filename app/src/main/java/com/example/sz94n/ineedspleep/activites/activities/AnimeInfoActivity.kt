package com.example.sz94n.ineedspleep.activites.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.sz94n.ineedspleep.R
import com.example.sz94n.ineedspleep.activites.models.anime.Anime
import com.example.sz94n.myanimeguide.junk.Consts
import com.example.sz94n.myanimeguide.junk.loadImageFromURL
import kotlinx.android.synthetic.main.activity_anime_info.*
import kotlinx.android.synthetic.main.content_anime_info.*

class AnimeInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anime_info)
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
//        actionBar?.title=   "New Avtivity"
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val animeInfo = intent.extras.getParcelable(Consts.ANIME_KEY) as Anime

        animeFab.setOnClickListener { view ->
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(animeInfo!!.url)
            )
            startActivity(intent)
        }
        animeScoreTextView.text = animeInfo.score.toString()
        animeEpisodesTextView.text = animeInfo.episodes.toString()
        animeTypeTextView.text = animeInfo.type
        animeSynopsisTextView.text = animeInfo.synopsis
        animeToolbarLayout.title = animeInfo.title
        animeInfoTopPosterImageView.loadImageFromURL(animeInfo.imageUrl)
        //lalala.loadImageFromURL(animeInfo.imageUrl)

    }

//    override fun onSupportNavigateUp(): Boolean {
//        onBackPressed()
//        return true
//    }
}
