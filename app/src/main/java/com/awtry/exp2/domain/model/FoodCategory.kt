package com.awtry.exp2.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
@JsonClass(generateAdapter = true)
class FoodCategory (
    @PrimaryKey(autoGenerate = false)
    val idCategory: Int = 0,
    @Json(name = "strCategory") val nameCategory: String = "",
    @Json(name = "strCategoryThumb") val imageCategory: String = "",
    @Json(name = "strCategoryDescription") val descriptionCategory: String = ""
) : Parcelable {
    //TODO: Agregar lo de la url a la imagen si hace falta para el cambio de grid
}