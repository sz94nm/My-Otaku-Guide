package com.example.sz94n.myanimeguide.interfaces


import com.example.sz94n.ineedspleep.activites.models.anime.AnimeSearchResponse
import com.example.sz94n.ineedspleep.activites.models.character.CharacterSearchResponse
import com.example.sz94n.ineedspleep.activites.models.manga.MangaSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchInterface {


    @GET("search/anime")
    fun searchAnime(@Query("q") searchQuery: String): Call<AnimeSearchResponse>

    @GET("search/manga")
    fun searchManga(@Query("q") searchQuery: String): Call<MangaSearchResponse>

    @GET("search/character")
    fun searchCharacter(@Query("q") searchQuery: String): Call<CharacterSearchResponse>


}