package com.awtry.exp2.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import androidx.room.Update
import com.awtry.exp2.domain.model.FoodCategory

@Dao
interface FoodCategoryDAO {


    @Query("SELECT * FROM FoodCategory")
    fun getAllFoodCategories(): List<FoodCategory>

    @Insert(onConflict = IGNORE)
    fun onSaveFoodCategory(categories: List<FoodCategory>): List<Long>

    @Update
    fun onUpdateFoodCategory(categories: FoodCategory): Int

}