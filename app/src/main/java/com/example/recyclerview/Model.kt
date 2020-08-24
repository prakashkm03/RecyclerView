package com.example.recyclerview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Model
    (
    val imageResource: Int,
    var text1: String,
    var text2: String
) : Parcelable