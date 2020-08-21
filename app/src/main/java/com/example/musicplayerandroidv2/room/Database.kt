package com.example.musicplayerandroidv2.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [(ArtistAlbum::class),(SongAlbum::class)], version = 2, exportSchema = false)
abstract class AppRoomDatabase : RoomDatabase() {

    abstract fun artistDao(): ArtistDao

    companion object {
        private var DATABASE_INSTANCE: AppRoomDatabase? = null

        fun getDatabaseIntance(context: Context): AppRoomDatabase {
            if (DATABASE_INSTANCE != null) {
                return DATABASE_INSTANCE as AppRoomDatabase
            }
            DATABASE_INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                AppRoomDatabase::class.java,
                "Spotify_database"
            ).fallbackToDestructiveMigration().build()

            return DATABASE_INSTANCE as AppRoomDatabase
        }

    }
}