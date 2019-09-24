package com.receipttracker.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.receipttracker.model.ReceiptServiceType
import com.receipttracker.model.SavedReceipt


@Dao
interface SavedReceiptDao{


    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun createReceipt(savedReceipt: SavedReceipt)

    @Query("SELECT * FROM saved_receipt_table")
    fun getAllReceipts(): LiveData<List<SavedReceipt>>

  //@Query("select* from saved_receipt_table where receiptServiceType = :services")
  // fun searchFilterByService(services: ReceiptServiceType)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateReceipt(savedReceipt: SavedReceipt)

    @Delete
    fun deleteReceipt(savedReceipt: SavedReceipt)


}