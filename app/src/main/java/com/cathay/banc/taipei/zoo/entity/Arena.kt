package com.cathay.banc.taipei.zoo.entity

import android.os.Parcel
import android.os.Parcelable
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.cathay.banc.taipei.zoo.BR
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
    @SerializedName("E_Pic_URL") var _ePicUrl: String = "",
    @SerializedName("E_Name") var _eName: String = "",
    @SerializedName("E_Info") var _eInfo: String = "",
    @SerializedName("E_Memo") var _eMemo: String = "無休館資訊",
    @SerializedName("E_Category") var _eCategory: Category = Category.未知分類,
    @SerializedName("E_URL") var _eUrl: String = "",
) : Parcelable, CommonItem, BaseObservable() {

    /*
        parcelable
     */
    companion object : Parceler<Arena> {
        override fun Arena.write(parcel: Parcel, flags: Int) {
            parcel.writeLong(_id)
            parcel.writeString(_ePicUrl)
            parcel.writeString(_eName)
            parcel.writeString(_eInfo)
            parcel.writeString(_eMemo)
            parcel.writeString(_eCategory.name)
            parcel.writeString(_eUrl)
        }

        override fun create(parcel: Parcel): Arena {
            val arena = Arena()

            arena._id = parcel.readLong()
            arena._ePicUrl = parcel.readString() ?: ""
            arena._eName = parcel.readString() ?: ""
            arena._eInfo = parcel.readString() ?: ""
            arena._eMemo = parcel.readString() ?: ""
            arena._eCategory = Category.valueOf(parcel.readString() ?: Category.未知分類.name)
            arena._eUrl = parcel.readString() ?: ""

            return arena
        }
    }

    /*
        CommonItem
     */
    override fun getAvatarUrl(): String = ePicUrl
    override fun getTitle(): String = eName
    override fun getDescription(): String = eInfo
    override fun getInfo(): String = eMemo

    /*
        base observable
     */
    var id: Long
        @Bindable get() = _id
        set(value) {
            _id = value
            notifyPropertyChanged(BR.id)
        }
    var ePicUrl: String
        @Bindable get() = _ePicUrl
        set(value) {
            _ePicUrl = value
            notifyPropertyChanged(BR.ePicUrl)
        }
    var eName: String
        @Bindable get() = _eName
        set(value) {
            _eName = value
            notifyPropertyChanged(BR.eName)
        }
    var eInfo: String
        @Bindable get() = _eInfo
        set(value) {
            _eInfo = value
            notifyPropertyChanged(BR.eInfo)
        }
    var eMemo: String
        @Bindable get() = _eMemo
        set(value) {
            _eMemo = value
            notifyPropertyChanged(BR.eMemo)
        }
    var eCategory: Category
        @Bindable get() = _eCategory
        set(value) {
            _eCategory = value
            notifyPropertyChanged(BR.eCategory)
        }
    var eUrl: String
        @Bindable get() = _eUrl
        set(value) {
            _eUrl = value
            notifyPropertyChanged(BR.eUrl)
        }
}

enum class Category {
    室內區, 戶外區, 未知分類;
}
