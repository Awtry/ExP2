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
class Food(
    @PrimaryKey(autoGenerate = false)
    val idFood: Int = 0,
    @Json(name = "strMeal") val name: String = "",
    @Json(name = "strCategory") val category: String = "",
    @Json(name = "strArea") val originArea: String = "",
    @Json(name = "strInstructions") val instructions: String = "",
    @Json(name = "strMealThumb") val picture: String = "",
    @Json(name = "strYoutube") val youtube: String = ""
) : Parcelable {

    //TODO: Agregar la parte de la fotografía
}