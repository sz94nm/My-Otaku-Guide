package com.example.sz94n.ineedspleep.activites.models.anime

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Anime(
    @SerializedName("mal_id")
    var malId: Int = 0, // 7580
    @SerializedName("url")
    var url: String = "", // https://myanimelist.net/anime/7580/Ikkitousen__Xtreme_Xecutor
    @SerializedName("image_url")
    var imageUrl: String = "", // https://cdn.myanimelist.net/images/anime/2/18209.jpg?s=17387dbd01b8d7ff42e8ef4573da36db
    @SerializedName("title")
    var title: String = "", // Ikkitousen: Xtreme Xecutor
    @SerializedName("airing")
    var airing: Boolean = false, // false
    @SerializedName("synopsis")
    var synopsis: String = "", // Life gets crazy for Hakufu when she takes on a pupil that acts just like her! A tournament between the school heads start, but due to Hakufu's negligence, her pupil ends up taking her place. The tourn...
    @SerializedName("type")
    var type: String = "", // TV
    @SerializedName("episodes")
    var episodes: Int = 0, // 12
    @SerializedName("score")
    var score: Double = 0.0, // 6.89
    @SerializedName("start_date")
    var startDate: String = "", // 2010-03-26T00:00:00+00:00
    @SerializedName("end_date")
    var endDate: String = "", // 2010-06-11T00:00:00+00:00
    @SerializedName("members")
    var members: Int = 0, // 34990
    @SerializedName("rated")
    var rated: String = "" // R+
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
        parcel.readDouble(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(malId)
        parcel.writeString(url)
        parcel.writeString(imageUrl)
        parcel.writeString(title)
        parcel.writeByte(if (airing) 1 else 0)
        parcel.writeString(synopsis)
        parcel.writeString(type)
        parcel.writeInt(episodes)
        parcel.writeDouble(score)
        parcel.writeString(startDate)
        parcel.writeString(endDate)
        parcel.writeInt(members)
        parcel.writeString(rated)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Anime> {
        override fun createFromParcel(parcel: Parcel): Anime {
            return Anime(parcel)
        }

        override fun newArray(size: Int): Array<Anime?> {
            return arrayOfNulls(size)
        }
    }
}
