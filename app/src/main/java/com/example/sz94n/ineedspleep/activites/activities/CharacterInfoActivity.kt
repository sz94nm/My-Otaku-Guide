package com.example.sz94n.ineedspleep.activites.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.sz94n.ineedspleep.R
import com.example.sz94n.ineedspleep.activites.adapters.AppearancesAdapter
import com.example.sz94n.ineedspleep.activites.adapters.NamesAdapter
import com.example.sz94n.ineedspleep.activites.models.character.Character
import com.example.sz94n.myanimeguide.junk.Consts
import com.example.sz94n.myanimeguide.junk.loadImageFromURL
import kotlinx.android.synthetic.main.activity_charcater_info.*
import kotlinx.android.synthetic.main.content_charcater_info.*

class CharacterInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_charcater_info)
        setSupportActionBar(characterToolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        val characterInfo: Character? = intent.getParcelableExtra(Consts.CHARACTER_KEY)
        fab.setOnClickListener { view ->
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(characterInfo!!.url)
            )
            startActivity(intent)
        }


        characterInfo?.let {
            characterToolbarLayout.title = characterInfo.name
            characterInfoTopPosterImageView.loadImageFromURL(characterInfo.imageUrl)
            if (characterInfo.alternativeNames.isEmpty()) {
                alternetiveNamesTextView.visibility = View.INVISIBLE
                alternativeNamesRecyclerView.visibility = View.INVISIBLE
            } else {
                alternativeNamesRecyclerView.layoutManager =
                        LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
                alternativeNamesRecyclerView.adapter = NamesAdapter(characterInfo.alternativeNames)
            }
            if (characterInfo.anime.isEmpty()) {
                animeAppearancesTextView.visibility = View.INVISIBLE
                animeAppearancesRecyclerView.visibility = View.INVISIBLE
            } else {
                animeAppearancesRecyclerView.layoutManager =
                        LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
                animeAppearancesRecyclerView.adapter = AppearancesAdapter(characterInfo.anime)
            }
            if (characterInfo.manga.isEmpty()) {
                mangaAppearancesTextView.visibility = View.INVISIBLE
                mangaAppearancesRecyclerView.visibility = View.INVISIBLE
            } else {
                mangaAppearancesRecyclerView.layoutManager =
                        LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
                mangaAppearancesRecyclerView.adapter = AppearancesAdapter(characterInfo.manga)
            }
        }

// characterRecyclerView.layoutManager = GridLayoutManager(activity, 2)
//        characterRecyclerView.adapter = CharacterAdapter(characterList)

    }
}
