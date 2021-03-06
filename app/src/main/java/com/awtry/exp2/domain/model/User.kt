package com.awtry.exp2.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
class User (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String = "",
    val mail: String = ""
){

}