package com.example.sz94n.ineedspleep.activites.models.manga

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Manga(
    @SerializedName("mal_id")
    var malId: Int = 0, // 77419
    @SerializedName("url")
    var url: String = "", // https://myanimelist.net/manga/77419/Kiruto
    @SerializedName("image_url")
    var imageUrl: String = "", // https://cdn.myanimelist.net/images/manga/2/134043.jpg?s=e836117eb56accffdfc1485d8eedf123
    @SerializedName("title")
    var title: String = "", // Kiruto
    @SerializedName("publishing")
    var publishing: Boolean = false, // false
    @SerializedName("synopsis")
    var synopsis: String = "",
    @SerializedName("type")
    var type: String = "", // Manga
    @SerializedName("chapters")
    var chapters: Int = 0, // 0
    @SerializedName("volumes")
    var volumes: Int = 0, // 4
    @SerializedName("score")
    var score: Double = 0.0, // 0
    @SerializedName("start_date")
    var startDate: String = "", // 2002-02-06T00:00:00+00:00
    @SerializedName("end_date")
    var endDate: String = "", // 2003-05-06T00:00:00+00:00
    @SerializedName("members")
    var members: Int = 0 // 54
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(malId)
        parcel.writeString(url)
        parcel.writeString(imageUrl)
        parcel.writeString(title)
        parcel.writeByte(if (publishing) 1 else 0)
        parcel.writeString(synopsis)
        parcel.writeString(type)
        parcel.writeInt(chapters)
        parcel.writeInt(volumes)
        parcel.writeDouble(score)
        parcel.writeString(startDate)
        parcel.writeString(endDate)
        parcel.writeInt(members)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Manga> {
        override fun createFromParcel(parcel: Parcel): Manga {
            return Manga(parcel)
        }

        override fun newArray(size: Int): Array<Manga?> {
            return arrayOfNulls(size)
        }
    }
}