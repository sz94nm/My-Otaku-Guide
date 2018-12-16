package com.example.sz94n.ineedspleep.activites.adapters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sz94n.ineedspleep.R
import com.example.sz94n.ineedspleep.activites.activities.CharacterInfoActivity
import com.example.sz94n.ineedspleep.activites.models.character.Character
import com.example.sz94n.myanimeguide.junk.Consts
import com.example.sz94n.myanimeguide.junk.loadImageFromURL
import kotlinx.android.synthetic.main.item.view.*

class CharacterAdapter(val characterList: List<Character>) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return CharacterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    override fun onBindViewHolder(viewHolder: CharacterViewHolder, position: Int) {
        viewHolder.setCharacter(characterList[position])
    }


    inner class CharacterViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        init {
            view.setOnClickListener {

                // val id = characterList[layoutPosition].malId

                val intent = Intent(it.context, CharacterInfoActivity::class.java)
                intent.putExtra(Consts.CHARACTER_KEY,characterList[layoutPosition])

                it.context.startActivity(intent)

            }
        }

        fun setCharacter(character: Character) {

            view.itemTitleTextView.text = character.name
            view.itemPosterImageView.loadImageFromURL(character.imageUrl)
        }

    }
}
