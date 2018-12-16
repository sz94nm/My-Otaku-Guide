package com.example.sz94n.ineedspleep.activites.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sz94n.ineedspleep.R

import kotlinx.android.synthetic.main.item_names.view.*

class NamesAdapter(val namesList: List<String>) : RecyclerView.Adapter<NamesAdapter.NamesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NamesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_names, parent, false)
        return NamesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return namesList.size
    }

    override fun onBindViewHolder(viewHolder: NamesViewHolder, position: Int) {
        viewHolder.setNames(namesList[position])
    }


    inner class NamesViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

//        init {
//            view.setOnClickListener {
//
//                // val id = namesList[layoutPosition].malId
//
//                val intent = Intent(it.context, CharacterInfoActivity::class.java)
//                intent.putExtra("ID",namesList[layoutPosition])
//
//                it.context.startActivity(intent)
//
//            }
//        }

        fun setNames(names: String) {
//
//            view.itemTitleTextView.text = names.name
//            view.itemPosterImageView.loadImageFromURL(names.imageUrl)


            view.namesTextView.text = names

        }

    }
}
