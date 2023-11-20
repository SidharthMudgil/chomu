package com.sidharth.chomu.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Options(
    val formality: String,
    val tone: String,
    val length: String,
    val style: String
) : Parcelable
