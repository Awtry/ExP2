package com.awtry.exp2.core.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.awtry.exp2.framework.db.FoodCategoryDB
import com.awtry.exp2.framework.db.FoodDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    private val MIGRATION_1_2 = object: Migration(1,2){
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE Food ADD COLUMN AllData TEXT")
        }
    }

    private val MIGRATION_2_3 = object: Migration(2,3){
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("DROP TABLE Food")
            database.execSQL("CREATE TABLE IF NOT EXISTS Food(idMeal INTEGER PRIMARY KEY NOT NULL, name TEXT NOT NULL, category TEXT NOT NULL, originArea TEXT NOT NULL, instructions TEXT NOT NULL, picture TEXT NOT NULL, youtube TEXT NOT NULL) ")

        }
    }

    private val MIGRATION_3_4 = object: Migration(3,4){
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("DROP TABLE Food")
            database.execSQL("CREATE TABLE IF NOT EXISTS Food(idMeal INTEGER PRIMARY KEY NOT NULL, name TEXT NOT NULL, category TEXT NOT NULL, originArea TEXT NOT NULL, instructions TEXT NOT NULL, picture TEXT NOT NULL, youtube TEXT NOT NULL) ")

        }
    }

    private val CATE_MIGRATION_1_2 = object: Migration(1,2){
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE FoodCategory ADD COLUMN AllData TEXT")
        }
    }

    @Provides
    @Singleton
    fun provideFoodDB(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, FoodDB::class.java, "Food").addMigrations(
            MIGRATION_1_2, MIGRATION_2_3, MIGRATION_3_4
        ).build()

    @Provides
    @Singleton
    fun provideFoodCategoryDB(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, FoodCategoryDB::class.java, "foodCategories").addMigrations(
            CATE_MIGRATION_1_2
        ).build()
}