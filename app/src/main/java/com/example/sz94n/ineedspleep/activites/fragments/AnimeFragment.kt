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
import com.example.sz94n.ineedspleep.activites.adapters.AnimeAdapter
import com.example.sz94n.ineedspleep.activites.models.anime.Anime
import com.example.sz94n.ineedspleep.activites.models.anime.AnimeSearchResponse
import com.example.sz94n.myanimeguide.interfaces.SearchInterface
import com.example.sz94n.myanimeguide.junk.Consts
import com.example.sz94n.myanimeguide.junk.setTextChangedListener
import kotlinx.android.synthetic.main.fragment_anime.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AnimeFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_anime, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        search("ergo")



        animeTextEdit.setTextChangedListener {
            if (it.length > 2)
                search(it)
        }


    }


    fun search(searchQuery: String) {
        animeLoadingImageView.visibility = View.VISIBLE
        animeTintView.visibility = View.VISIBLE

        Log.i("TAG", searchQuery)
        val retrofit = Retrofit.Builder()
            .baseUrl(Consts.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val searchInterface = retrofit.create(SearchInterface::class.java)

        searchInterface.searchAnime(searchQuery)
            .enqueue(object : Callback<AnimeSearchResponse> {

                override fun onFailure(call: Call<AnimeSearchResponse>, t: Throwable) {
                    Toast.makeText(activity, t.message, Toast.LENGTH_LONG).show()
                    if (animeLoadingImageView != null) {
                        animeLoadingImageView.visibility = View.INVISIBLE
                        animeTintView.visibility = View.INVISIBLE
                        Toast.makeText(activity, "No Results Were Found", Toast.LENGTH_LONG).show()

                    }
                }

                override fun onResponse(call: Call<AnimeSearchResponse>, response: Response<AnimeSearchResponse>) {
                    if (animeLoadingImageView != null) {
                        animeLoadingImageView.visibility = View.INVISIBLE
                        animeTintView.visibility = View.INVISIBLE
                    }
                    Log.i("AnimeResponse", "${response.raw()}")
                    response.body()?.results?.let {
                        prepareRecyclerView(it)
                    }
                }

            })

    }

    private fun prepareRecyclerView(animeList: List<Anime>) {

        if (animeRecyclerView != null) {
            animeRecyclerView.layoutManager = GridLayoutManager(activity, 2)
            animeRecyclerView.adapter = AnimeAdapter(animeList)
        }
    }

    override fun onStop() {
        super.onStop()

    }

}
