package com.example.sz94n.ineedspleep.activites.models.character

import android.os.Parcel
import android.os.Parcelable
import com.example.sz94n.ineedspleep.activites.models.BaseSearchResponse
import com.google.gson.annotations.SerializedName

data class CharacterSearchResponse(
    @SerializedName("results")
    var results: List<Character> = listOf(),
    @SerializedName("last_page")
    var lastPage: Int = 0 // 20
) : BaseSearchResponse(), Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.createTypedArrayList(com.example.sz94n.ineedspleep.activites.models.character.Character),
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

    companion object CREATOR : Parcelable.Creator<CharacterSearchResponse> {
        override fun createFromParcel(parcel: Parcel): CharacterSearchResponse {
            return CharacterSearchResponse(parcel)
        }

        override fun newArray(size: Int): Array<CharacterSearchResponse?> {
            return arrayOfNulls(size)
        }
    }
}

