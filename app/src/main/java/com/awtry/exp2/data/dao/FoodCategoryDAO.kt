package com.awtry.exp2.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import androidx.room.Update
import com.awtry.exp2.domain.model.FoodCategory

@Dao
interface FoodCategoryDAO {

    //Base de datos local para cuando se desconecte de la red aun se puendan
    //ver los datos

    //SOLO PRARA CATEGORIAS
    //TODO: Cambiar la dirección de la base de datos
    @Query("SELECT * FROM FoodCategory WHERE nameCategory LIKE :filter")
    fun getFoodCategoryByName(filter: String): List<FoodCategory>

    @Insert(onConflict = IGNORE)
    fun onSaveFoodCategory(dishCategory: List<FoodCategory>): List<Long>

    @Update
    fun onUpdateFoodCategory(dishCategory: FoodCategory): Int

}