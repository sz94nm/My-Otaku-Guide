package com.example.sz94n.ineedspleep.activites.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.sz94n.ineedspleep.R
import com.example.sz94n.ineedspleep.activites.adapters.CharacterAdapter
import com.example.sz94n.ineedspleep.activites.models.character.Character
import com.example.sz94n.ineedspleep.activites.models.character.CharacterSearchResponse
import com.example.sz94n.myanimeguide.interfaces.SearchInterface
import com.example.sz94n.myanimeguide.junk.Consts
import com.example.sz94n.myanimeguide.junk.setTextChangedListener
import kotlinx.android.synthetic.main.fragment_character.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharacterFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_character, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        search("okabe rin")
        characterTextEdit.setTextChangedListener() {
            if (it.length > 2)
                search(it)
        }
    }

    fun search(searchQuery: String) {
        characterLoadingImageView.visibility = View.VISIBLE
        characterTintView.visibility = View.VISIBLE

        Log.i("TAG", searchQuery)
        val retrofit = Retrofit.Builder()
            .baseUrl(Consts.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val searchInterface = retrofit.create(SearchInterface::class.java)
        searchInterface.searchCharacter(searchQuery)
            .enqueue(object : Callback<CharacterSearchResponse> {
                override fun onFailure(call: Call<CharacterSearchResponse>, t: Throwable) {
                    Toast.makeText(activity, t.message, Toast.LENGTH_LONG).show()
                    if (characterLoadingImageView != null) {
                        characterLoadingImageView.visibility = View.INVISIBLE
                        characterTintView.visibility = View.INVISIBLE
                        Toast.makeText(activity, "No Results Were Found", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onResponse(
                    call: Call<CharacterSearchResponse>,
                    response: Response<CharacterSearchResponse>
                ) {
                    response.body()?.results?.let {
                        prepareRecyclerView(it)
                        if (characterLoadingImageView != null) {
                            characterLoadingImageView.visibility = View.INVISIBLE
                            characterTintView.visibility = View.INVISIBLE
                        }
                    }
                }
            })
    }

    private fun prepareRecyclerView(characterList: List<Character>) {
        if (characterRecyclerView != null) {
            characterRecyclerView.layoutManager = GridLayoutManager(activity, 2)
            characterRecyclerView.adapter = CharacterAdapter(characterList)
        }
    }

    override fun onStop() {
        super.onStop()
    }
}