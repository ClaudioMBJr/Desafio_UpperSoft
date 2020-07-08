package com.example.appandroid

import com.google.gson.annotations.SerializedName

class SerializedJson {
    data class First (
        @SerializedName("data") var data : Data
    )

    data class Data(
        @SerializedName("dist") var dist : Int,
        @SerializedName("children") var children : List<Children> = emptyList()
    )

    data class Children(
        @SerializedName("data") var data2 : Data2
    )

    data class Data2(
        @SerializedName("title") var title : String = ""
    )
}