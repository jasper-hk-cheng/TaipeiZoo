package com.cathay.banc.taipei.zoo.entity

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parceler
import kotlinx.android.parcel.Parcelize

data class ArenaResult(
    @SerializedName("result") var result: ArenaEnvelope = ArenaEnvelope(),
)

data class ArenaEnvelope(
    @SerializedName("limit") var limit: Int = 0,
    @SerializedName("offset") var offset: Int = 0,
    @SerializedName("count") var count: Int = 0,
    @SerializedName("sort") var sort: String = "",
    @SerializedName("results") var results: List<Arena> = listOf(),
)

@Parcelize
data class Arena(
    @SerializedName("_id") var _id: Long = 0L,
    @SerializedName("E_Pic_URL") var avatarUrl: String = "",
    @SerializedName("E_Name") var title: String = "",
    @SerializedName("E_Info") var description: String = "",
    @SerializedName("E_Memo") var info: String = "無休館資訊",
    @SerializedName("E_Category") var category: Category = Category.未知分類,
    @SerializedName("E_URL") var url: String = "",
) : Parcelable {
    companion object : Parceler<Arena> {
        override fun Arena.write(parcel: Parcel, flags: Int) {
            parcel.writeString(avatarUrl)
            parcel.writeString(title)
            parcel.writeString(description)
            parcel.writeString(info)
            parcel.writeString(category.name)
            parcel.writeString(url)
        }

        override fun create(parcel: Parcel): Arena {
            val arena = Arena()

            arena.avatarUrl = parcel.readString() ?: ""
            arena.title = parcel.readString() ?: ""
            arena.description = parcel.readString() ?: ""
            arena.info = parcel.readString() ?: ""
            arena.category = Category.valueOf(parcel.readString() ?: Category.未知分類.name)
            arena.url = parcel.readString() ?: ""

            return arena
        }
    }
}

enum class Category {
    室內區, 戶外區, 未知分類;
}
