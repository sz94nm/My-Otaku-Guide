package com.example.sz94n.myanimeguide.junk

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import com.squareup.picasso.Picasso

fun EditText.setTextChangedListener(callback: (text: String) -> Unit) {

    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            callback(s.toString())

        }

    })

}

fun ImageView.loadImageFromURL(url: String) {

    Picasso.get()
        .load(url)
        .into(this)

}