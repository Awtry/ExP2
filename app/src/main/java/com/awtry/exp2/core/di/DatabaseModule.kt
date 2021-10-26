package com.awtry.exp2.core.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
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

    @Provides
    @Singleton
    fun provideFoodDB(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, FoodDB::class.java, "foods").addMigrations(
            MIGRATION_1_2
        ).build()
}