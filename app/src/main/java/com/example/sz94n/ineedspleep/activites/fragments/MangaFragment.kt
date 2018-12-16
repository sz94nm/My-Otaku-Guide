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
import com.example.sz94n.ineedspleep.activites.adapters.MangaAdapter
import com.example.sz94n.ineedspleep.activites.models.manga.Manga
import com.example.sz94n.ineedspleep.activites.models.manga.MangaSearchResponse
import com.example.sz94n.myanimeguide.interfaces.SearchInterface
import com.example.sz94n.myanimeguide.junk.Consts
import com.example.sz94n.myanimeguide.junk.setTextChangedListener
import kotlinx.android.synthetic.main.fragment_manga.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MangaFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_manga, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        search("gantz")

        mangaTextEdit.setTextChangedListener() {
            if (it.length > 2)
                search(it)
        }
    }

    fun search(searchQuery: String) {
        mangaLoadingImageView.visibility = View.VISIBLE
        mangaTintView.visibility = View.VISIBLE

        Log.i("TAG", searchQuery)
        val retrofit = Retrofit.Builder()
            .baseUrl(Consts.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val searchInterface = retrofit.create(SearchInterface::class.java)
        searchInterface.searchManga(searchQuery)
            .enqueue(object : Callback<MangaSearchResponse> {
                override fun onFailure(call: Call<MangaSearchResponse>, t: Throwable) {
                    Toast.makeText(activity, t.message, Toast.LENGTH_LONG).show()
                    if (mangaLoadingImageView != null) {
                        mangaLoadingImageView.visibility = View.INVISIBLE
                        mangaTintView.visibility = View.INVISIBLE
                        Toast.makeText(activity, "No Results Were Found", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onResponse(call: Call<MangaSearchResponse>, response: Response<MangaSearchResponse>) {
                    response.body()?.results?.let {
                        prepareRecyclerView(it)
                        if (mangaLoadingImageView != null) {
                            mangaLoadingImageView.visibility = View.INVISIBLE
                            mangaTintView.visibility = View.INVISIBLE
                        }
                    }
                }
            })
    }

    private fun prepareRecyclerView(mangaList: List<Manga>) {

        if (mangaRecyclerView != null) {
            mangaRecyclerView.layoutManager = GridLayoutManager(activity, 2)
            mangaRecyclerView.adapter = MangaAdapter(mangaList)
        }
    }
}