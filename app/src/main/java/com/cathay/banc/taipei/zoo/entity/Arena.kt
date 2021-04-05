package com.cathay.banc.taipei.zoo.entity

import android.os.Parcel
import android.os.Parcelable
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
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
    @SerializedName("E_Pic_URL") var _avatarUrl: String = "",
    @SerializedName("E_Name") var _title: String = "",
    @SerializedName("E_Info") var _description: String = "",
    @SerializedName("E_Memo") var _info: String = "無休館資訊",
    @SerializedName("E_Category") var _category: Category = Category.未知分類,
    @SerializedName("E_URL") var _url: String = "",
) : Parcelable, BaseObservable() {

    companion object : Parceler<Arena> {
        override fun Arena.write(parcel: Parcel, flags: Int) {
            parcel.writeLong(_id)
            parcel.writeString(_avatarUrl)
            parcel.writeString(_title)
            parcel.writeString(_description)
            parcel.writeString(_info)
            parcel.writeString(_category.name)
            parcel.writeString(_url)
        }

        override fun create(parcel: Parcel): Arena {
            val arena = Arena()

            arena._id = parcel.readLong()
            arena._avatarUrl = parcel.readString() ?: ""
            arena._title = parcel.readString() ?: ""
            arena._description = parcel.readString() ?: ""
            arena._info = parcel.readString() ?: ""
            arena._category = Category.valueOf(parcel.readString() ?: Category.未知分類.name)
            arena._url = parcel.readString() ?: ""

            return arena
        }
    }

    val avatarUrl: String
        @Bindable get() = _avatarUrl
    val description: String
        @Bindable get() = _description
    val info: String
        @Bindable get() = _info
    val category: Category
        @Bindable get() = _category
    val url: String
        @Bindable get() = _url
}

enum class Category {
    室內區, 戶外區, 未知分類;
}
