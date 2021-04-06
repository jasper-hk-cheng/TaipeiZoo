package com.cathay.banc.taipei.zoo.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.cathay.banc.taipei.zoo.BR
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parceler
import kotlinx.android.parcel.Parcelize

data class PlantResult(
    @SerializedName("result") var result: PlantEnvelope,
)

data class PlantEnvelope(
    @SerializedName("limit") var limit: Int,
    @SerializedName("offset") var offset: Int,
    @SerializedName("count") var count: Int,
    @SerializedName("sort") var sort: String,
    @SerializedName("results") var results: List<Plant>,
)

@Parcelize
data class Plant(
    @SerializedName("_id") var _id: Long = 0L,
    @SerializedName("F_Pic01_URL") var _fPic01Url: String = "",
    @SerializedName("\ufeffF_Name_Ch") var _fNameCh: String = "",
    @SerializedName("F_AlsoKnown") var _fAlsoKnown: String = "",
    @SerializedName("F_Name_Latin") var _fNameLatin: String = "",
    @SerializedName("F_Brief") var _fBrief: String = "",
    @SerializedName("F_Feature") var _fFeature: String = "",
    @SerializedName("F_Function＆Application") var _fFunctionAndApplication: String = "",
    @SerializedName("F_Update") var _fUpdate: String = "",
) : Parcelable, CommonItem, BaseObservable() {

    /*
        parcelable
     */
    companion object : Parceler<Plant> {
        override fun Plant.write(parcel: Parcel, flags: Int) {
            parcel.writeLong(_id)
            parcel.writeString(_fPic01Url)
            parcel.writeString(_fNameCh)
            parcel.writeString(_fAlsoKnown)
            parcel.writeString(_fNameLatin)
            parcel.writeString(_fBrief)
            parcel.writeString(_fFeature)
            parcel.writeString(_fFunctionAndApplication)
            parcel.writeString(_fUpdate)
        }

        override fun create(parcel: Parcel): Plant {
            val plant = Plant()

            plant._id = parcel.readLong()
            plant._fPic01Url = parcel.readString() ?: ""
            plant._fNameCh = parcel.readString() ?: ""
            plant._fAlsoKnown = parcel.readString() ?: ""
            plant._fNameLatin = parcel.readString() ?: ""
            plant._fBrief = parcel.readString() ?: ""
            plant._fFeature = parcel.readString() ?: ""
            plant._fFunctionAndApplication = parcel.readString() ?: ""
            plant._fUpdate = parcel.readString() ?: ""

            return plant
        }
    }

    /*
        CommonItem
     */
    override fun getAvatarUrl(): String = fPic01Url
    override fun getTitle(): String = fNameCh
    override fun getDescription(): String = fAlsoKnown
    override fun getInfo(): String = ""

    /*
        base observable
     */
    var id: Long
        @Bindable get() = _id
        set(value) {
            _id = value
            notifyPropertyChanged(BR.id)
        }
    var fPic01Url: String
        @Bindable get() = _fPic01Url
        set(value) {
            _fPic01Url = value
            notifyPropertyChanged(BR.id)
        }
    var fNameCh: String
        @Bindable get() = _fNameCh
        set(value) {
            _fNameCh = value
            notifyPropertyChanged(BR.id)
        }
    var fAlsoKnown: String
        @Bindable get() = _fAlsoKnown
        set(value) {
            _fAlsoKnown = value
            notifyPropertyChanged(BR.id)
        }
    var fNameLatin: String
        @Bindable get() = _fNameLatin
        set(value) {
            _fNameLatin = value
            notifyPropertyChanged(BR.id)
        }
    var fBrief: String
        @Bindable get() = _fBrief
        set(value) {
            _fBrief = value
            notifyPropertyChanged(BR.id)
        }
    var fFeature: String
        @Bindable get() = _fFeature
        set(value) {
            _fFeature = value
            notifyPropertyChanged(BR.id)
        }
    var fFunctionAndApplication: String
        @Bindable get() = _fFunctionAndApplication
        set(value) {
            _fFunctionAndApplication = value
            notifyPropertyChanged(BR.id)
        }
    var fUpdate: String
        @Bindable get() = _fUpdate
        set(value) {
            _fUpdate = value
            notifyPropertyChanged(BR.id)
        }
}
