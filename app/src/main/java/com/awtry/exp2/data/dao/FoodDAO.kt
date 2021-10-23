package com.awtry.exp2.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Update
import retrofit2.http.Query

@Dao
interface FoodDAO {

    //Base de datos local para cuando se desconecte de la red aun se puendan
    //ver los datos
    //TODO: Cambiar la dirección de la base de datos
    @Query("SELECT * FROM P2Elemento WHERE name LIKE :filter")
    fun getFoodByName(filter: String): List<P2Elemento>

    @Insert(onConflict = IGNORE)
    fun onSaveCocktail(cocktails: List<P2Elemento>): List<Long>

    @Update
    fun onUpdateCocktail(cocktail: P2Elemento): Int

}