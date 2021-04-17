package com.cathay.banc.taipei.zoo.entity

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.cathay.banc.taipei.zoo.BR

data class PlantSearchCondition(
    var _keyWord: String = "",
    var _offset: Int = 0,
    var _limit: Int = 5,
    var _currentPage: Int = 1,
) : BaseObservable() {
    /*
        for sending query parameter at retrofit
     */
    fun toQueryMap(): Map<String, String> = mapOf(
        "q" to _keyWord,
        "offset" to _offset.toString(),
        "limit" to _limit.toString(),
    )

    /*
        for showing current page on UI
     */


    fun goHome() {
        offset = 0
    }

    fun goNextPage() {
        offset += _limit
    }

    fun goPreviousPage() {
        offset -= _limit
    }

    companion object {
        val DEFAULT_CONDITION = PlantSearchCondition()
    }

    /*
        base observable
     */
    var keyWord: String
        @Bindable get() = _keyWord
        set(value) {
            _keyWord = value
            notifyPropertyChanged(BR.keyWord)
        }

    var offset: Int
        @Bindable get() = _offset
        set(value) {
            _offset = value
            // update current page
            currentPage = _offset / _limit + 1

            notifyPropertyChanged(BR.offset)
        }

    var limit: Int
        @Bindable get() = _limit
        set(value) {
            _limit = value
            notifyPropertyChanged(BR.limit)
        }

    var currentPage: Int
        @Bindable get() = _currentPage
        set(value) {
            _currentPage = value
            notifyPropertyChanged(BR.currentPage)
        }
}
