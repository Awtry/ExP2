package com.awtry.exp2.data.dao

import androidx.room.*
import com.awtry.exp2.domain.model.Food

@Dao
interface FoodDAO {

    //SOLO PRARA PLATILLOS
    //TODO: Cambiar la dirección de la base de datos
    @Query("SELECT * FROM Food WHERE name LIKE :filter")
    fun getFoodByName(filter: String): List<Food>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun onSaveFood(cocktails: List<Food>): List<Long>

    @Update
    fun onUpdateFood(cocktail: Food): Int

}