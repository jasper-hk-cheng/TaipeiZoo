package com.cathay.banc.taipei.zoo.entity

interface CommonItem {
    fun getAvatarUrl(): String
    fun getTitle(): String
    fun getDescription(): String
    fun getInfo(): String
}

/*
TODO
    class TemplateDataOF {
        val alias: ObservableField<String> = ObservableField()
        val age: ObservableField<Int> = ObservableField()
    }
 */