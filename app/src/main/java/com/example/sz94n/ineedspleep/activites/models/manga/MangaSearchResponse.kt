package com.example.sz94n.ineedspleep.activites.models.manga

import com.example.sz94n.ineedspleep.activites.models.BaseSearchResponse
import com.google.gson.annotations.SerializedName

data class MangaSearchResponse(
    @SerializedName("results")
    var results: List<Manga> = listOf(),
    @SerializedName("last_page")
    var lastPage: Int = 0 // 20
) : BaseSearchResponse()

