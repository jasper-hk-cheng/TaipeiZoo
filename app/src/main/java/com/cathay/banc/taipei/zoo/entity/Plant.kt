package com.cathay.banc.taipei.zoo.entity

import android.os.Parcel
import android.os.Parcelable
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
    @SerializedName("F_Pic01_URL") var avatarUrl: String = "",
    @SerializedName("\ufeffF_Name_Ch") var nameCh: String = "",
    @SerializedName("F_AlsoKnown") var alias: String = "",
    @SerializedName("F_Name_Latin") var nameLatin: String = "",
    @SerializedName("F_Brief") var brief: String = "",
    @SerializedName("F_Feature") var feature: String = "",
    @SerializedName("F_Function＆Application") var functionAndApplication: String = "",
    @SerializedName("F_Update") var updateDate: String = "",
) : Parcelable {

    companion object : Parceler<Plant> {
        override fun Plant.write(parcel: Parcel, flags: Int) {
            parcel.writeInt(_id.toInt())
            parcel.writeString(avatarUrl)
            parcel.writeString(nameCh)
            parcel.writeString(alias)
            parcel.writeString(nameLatin)
            parcel.writeString(brief)
            parcel.writeString(feature)
            parcel.writeString(functionAndApplication)
            parcel.writeString(updateDate)
        }

        override fun create(parcel: Parcel): Plant {
            val plant = Plant()

            plant._id = parcel.readInt().toLong()
            plant.avatarUrl = parcel.readString() ?: ""
            plant.nameCh = parcel.readString() ?: ""
            plant.alias = parcel.readString() ?: ""
            plant.nameLatin = parcel.readString() ?: ""
            plant.brief = parcel.readString() ?: ""
            plant.feature = parcel.readString() ?: ""
            plant.functionAndApplication = parcel.readString() ?: ""
            plant.updateDate = parcel.readString() ?: ""

            return plant
        }
    }
}
