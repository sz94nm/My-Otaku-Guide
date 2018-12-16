package com.example.sz94n.ineedspleep.activites.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.sz94n.ineedspleep.R
import com.example.sz94n.ineedspleep.activites.models.manga.Manga
import com.example.sz94n.myanimeguide.junk.Consts
import com.example.sz94n.myanimeguide.junk.loadImageFromURL
import kotlinx.android.synthetic.main.activity_manga_info.*
import kotlinx.android.synthetic.main.content_manga_info.*

class MangaInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manga_info)
        setSupportActionBar(mangaToolbar)
        val actionBar = supportActionBar
//        actionBar?.title=   " Avtivity"
        actionBar?.setDisplayHomeAsUpEnabled(true)
        val mangaInfo = intent.extras.getParcelable(Consts.MANGA_KEY) as Manga
        mangaFab.setOnClickListener { view ->
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(mangaInfo!!.url)
            )
            startActivity(intent)
        }

        mangaScoreTextView.text = mangaInfo.score.toString()
        mangaChapterTextView.text = mangaInfo.chapters.toString()
        mangaTypeTextView.text = mangaInfo.type
        mangaSynopsisTextView.text = mangaInfo.synopsis
        mangaToolbarLayout.title = mangaInfo.title
        mangaInfoTopPosterImageView.loadImageFromURL(mangaInfo.imageUrl)
/*
fab.setOnClickListener { view ->

}
*/
    }
}
