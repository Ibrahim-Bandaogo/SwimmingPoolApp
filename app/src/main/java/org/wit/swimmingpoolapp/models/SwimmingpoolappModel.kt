package org.wit.swimmingpoolapp.models


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SwimmingpoolappModel( var id: Long = 0,
                                var title: String = "",
                                var description: String = "") : Parcelable