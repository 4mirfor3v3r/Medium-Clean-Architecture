package com.acemirr.medium_clean_architecture.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.acemirr.medium_clean_architecture.BuildConfig
import com.acemirr.medium_clean_architecture.data.source.local.dao.ListDao
import com.acemirr.medium_clean_architecture.data.source.local.entity.LocalNewsModel

@Database(entities = [LocalNewsModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val listDao: ListDao

    companion object {
        const val DB_NAME = BuildConfig.APPLICATION_ID + ".DATABASE.db"
    }
}