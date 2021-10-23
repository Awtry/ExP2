package com.awtry.exp2.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.awtry.exp2.data.dao.FoodCategoryDAO
import com.awtry.exp2.domain.model.FoodCategory

@Database(entities = [FoodCategory::class], version = 1)
abstract class FoodCategoryDB : RoomDatabase(){
    abstract fun FoodCategoryDAO(): FoodCategoryDAO
}