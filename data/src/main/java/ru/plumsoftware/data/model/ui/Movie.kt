package ru.plumsoftware.data.model.ui

import android.os.Parcel
import android.os.Parcelable

class Movie(
    val preview: String?,
    val name: String,
    val description: String,
    val localizedName: String,
    val genres: Array<String>
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.createStringArray() ?: emptyArray()
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Movie

        if (preview != other.preview) return false
        if (name != other.name) return false
        if (description != other.description) return false
        if (localizedName != other.localizedName) return false
        if (!genres.contentEquals(other.genres)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = preview?.hashCode() ?: 0
        result = 31 * result + name.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + localizedName.hashCode()
        result = 31 * result + genres.contentHashCode()
        return result
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(preview)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(localizedName)
        parcel.writeStringArray(genres)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }

        fun empty(): Movie {
            return Movie(
                preview = null,
                name = "",
                description = "",
                localizedName = "",
                genres = emptyArray()
            )
        }
    }
}