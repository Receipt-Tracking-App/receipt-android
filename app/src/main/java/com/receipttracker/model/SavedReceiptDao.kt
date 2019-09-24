package com.receipttracker.model

import android.app.Service
import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface SavedReceiptDao{


    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun createReceipt(savedReceipt: SavedReceipt)

    @Query("SELECT * FROM saved_receipt_table")
    fun getAllReceipts(): LiveData<List<SavedReceipt>>

   @Query("select* from saved_receipt_table where receiptServiceType = :services")
   fun searchFilterByService(services: ReceiptServiceType)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateReceipt(savedReceipt: SavedReceipt)

    @Delete
    fun deleteReceipt(savedReceipt: SavedReceipt)


}