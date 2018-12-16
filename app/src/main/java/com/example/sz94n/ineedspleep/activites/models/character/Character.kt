package com.example.sz94n.ineedspleep.activites.models.character

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("mal_id")
    var malId: Int = 0, // 134344
    @SerializedName("url")
    var url: String = "", // https://myanimelist.net/character/134344/Smoking_Lightning
    @SerializedName("image_url")
    var imageUrl: String = "", // https://cdn.myanimelist.net/images/characters/8/294183.jpg?s=2abc6fe83b0151670935e0ab135332d7
    @SerializedName("name")
    var name: String = "", // Smoking Lightning
    @SerializedName("alternative_names")
    var alternativeNames: List<String> = listOf(),
    @SerializedName("anime")
    var anime: List<CharactersAppearances> = listOf(),
    @SerializedName("manga")
    var manga: List<CharactersAppearances> = listOf()
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList(),
        parcel.createTypedArrayList(CharactersAppearances),
        parcel.createTypedArrayList(CharactersAppearances)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(malId)
        parcel.writeString(url)
        parcel.writeString(imageUrl)
        parcel.writeString(name)
        parcel.writeStringList(alternativeNames)
        parcel.writeTypedList(anime)
        parcel.writeTypedList(manga)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Character> {
        override fun createFromParcel(parcel: Parcel): Character {
            return Character(parcel)
        }

        override fun newArray(size: Int): Array<Character?> {
            return arrayOfNulls(size)
        }
    }
}
