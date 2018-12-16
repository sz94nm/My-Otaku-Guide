package com.example.sz94n.ineedspleep.activites.models.anime

import android.os.Parcel
import android.os.Parcelable
import com.example.sz94n.ineedspleep.activites.models.BaseSearchResponse
import com.google.gson.annotations.SerializedName

data class AnimeSearchResponse(
    @SerializedName("results")
    var results: List<Anime> = listOf(),
    @SerializedName("last_page")
    var lastPage: Int = 0 // 20
) : BaseSearchResponse(), Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.createTypedArrayList(Anime),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(results)
        parcel.writeInt(lastPage)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AnimeSearchResponse> {
        override fun createFromParcel(parcel: Parcel): AnimeSearchResponse {
            return AnimeSearchResponse(parcel)
        }

        override fun newArray(size: Int): Array<AnimeSearchResponse?> {
            return arrayOfNulls(size)
        }
    }
}

