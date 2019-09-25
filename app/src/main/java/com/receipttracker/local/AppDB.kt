package com.receipttracker.local

import androidx.room.Database
import androidx.room.RoomDatabase
import android.content.Context
import androidx.room.Room
import com.receipttracker.model.*

@Database(entities = arrayOf(User::class, SavedReceipt::class, Groups::class, ReceiptMedia::class,Tags::class,ReceiptCategories::class, ReceiptMainCategories::class), version = 2, exportSchema = false)
abstract class AppDB : RoomDatabase(){

    abstract fun savedReceiptsDao() : SavedReceiptDao

    abstract fun userDao() : UserDao

    companion object {
        // Singleton prevents multiple instances of database from opening at the same time
        @Volatile
        private var INSTANCE: AppDB? = null

        fun getDatabase(context: Context) : AppDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDB::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}