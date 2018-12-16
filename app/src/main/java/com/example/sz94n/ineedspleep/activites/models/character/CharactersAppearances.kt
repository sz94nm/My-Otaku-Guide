package com.example.sz94n.ineedspleep.activites.models.character

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class CharactersAppearances(
    @SerializedName("mal_id")
    var malId: Int = 0, // 17265
    @SerializedName("type")
    var type: String = "", // anime
    @SerializedName("name")
    var name: String = "", // Log Horizon
    @SerializedName("url")
    var url: String = "" // https://myanimelist.net/anime/17265/Log_Horizon
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(malId)
        parcel.writeString(type)
        parcel.writeString(name)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CharactersAppearances> {
        override fun createFromParcel(parcel: Parcel): CharactersAppearances {
            return CharactersAppearances(parcel)
        }

        override fun newArray(size: Int): Array<CharactersAppearances?> {
            return arrayOfNulls(size)
        }
    }
}