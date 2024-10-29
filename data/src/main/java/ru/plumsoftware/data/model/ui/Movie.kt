package ru.plumsoftware.data.model.ui

import android.os.Parcel
import android.os.Parcelable

class Movie(
    val preview: String?,
    val name: String,
    val description: String,
    val localizedName: String,
    val year: Int,
    val rating: Float,
    val genres: Array<String>
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readFloat(),
        parcel.createStringArray() ?: emptyArray()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(preview)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(localizedName)
        parcel.writeInt(year)
        parcel.writeFloat(rating)
        parcel.writeStringArray(genres)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {

        fun empty(): Movie {
            return Movie(
                preview = null,
                name = "",
                description = "",
                localizedName = "",
                year = -1,
                rating = -0.1f,
                genres = emptyArray()
            )
        }

        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}