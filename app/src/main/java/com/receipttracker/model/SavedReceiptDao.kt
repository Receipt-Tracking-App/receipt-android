package com.receipttracker.model

import android.app.Service
import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface SavedReceiptDao{


    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun createReceipt(savedReceipt: SavedReceipt)

    @Query("select * from SavedReceipt")
    fun readAllReceipts(): LiveData<List<SavedReceipt>>

    @Query("select* from SavedReceipt where service = :services")
    fun searchFilterByService(services: Services)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateReceipt(savedReceipt: SavedReceipt)

    @Delete

    fun deleteReceipt(savedReceipt: SavedReceipt)


}