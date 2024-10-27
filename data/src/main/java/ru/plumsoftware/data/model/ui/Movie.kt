package ru.plumsoftware.data.model.ui

data class Movie(
    val preview: String?,
    val name: String,
    val description: String,
    val localizedName: String,
    val genres: Array<String>
) {

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
}