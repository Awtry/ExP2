package com.awtry.exp2.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.awtry.exp2.data.dao.FoodDAO
import com.awtry.exp2.domain.model.Food

@Database(entities = [Food::class], version = 1)
abstract class FoodDB : RoomDatabase() {
    abstract fun FoodDAO(): FoodDAO
}