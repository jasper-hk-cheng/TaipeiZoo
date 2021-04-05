package com.cathay.banc.taipei.zoo.entity

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.cathay.banc.taipei.zoo.BR

/*
    TODO
        modify var as val, and mark setter as comment...
        setter is not necessary, in this case, no data will be modified...
 */
class CommonItem private constructor() : BaseObservable() {

    /*
        kernel object
     */
    private var arena: Arena? = null
    private var plant: Plant? = null

    /*
        common properties
     */
    var avatarUrl: String = ""
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.avatarUrl)
        }
    var title: String = ""
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.title)
        }
    var description: String = ""
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.description)
        }
    var info: String = ""
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.info)
        }

    constructor(arena: Arena) : this() {
        this.arena = arena
        postConstructor()
    }

    constructor(plant: Plant) : this() {
        this.plant = plant
        postConstructor()
    }

    private fun postConstructor() {
        when {
            arena != null -> {
                avatarUrl = arena!!._avatarUrl
                title = arena!!._title
                description = arena!!._description
                info = arena!!._info
            }
            plant != null -> {
                avatarUrl = plant!!.avatarUrl
                title = plant!!.nameCh
                description = plant!!.alias
                info = ""
            }
        }
    }

    fun ejectKernel(): Any = when {
        arena != null -> arena!!
        plant != null -> plant!!
        else -> Any()
    }
}

/*
    class TemplateDataOF {
        val alias: ObservableField<String> = ObservableField()
        val age: ObservableField<Int> = ObservableField()
    }
 */