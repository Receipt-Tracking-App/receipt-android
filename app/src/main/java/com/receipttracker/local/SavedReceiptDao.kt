package com.receipttracker.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.receipttracker.local.common.BaseDao

import com.receipttracker.model.SavedReceipt


@Dao
abstract class SavedReceiptDao : BaseDao<SavedReceipt> {

    @Query("SELECT * FROM receipts")
    abstract fun getAllReceipts() : LiveData<List<SavedReceipt>>


}

/*    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun createReceipt(savedReceipt: SavedReceipt)

    @Query("SELECT * FROM receipts")
    fun getAllReceipts(): LiveData<List<SavedReceipt>>

  //@Query("select* from saved_receipt_table where receiptServiceType = :services")
  // fun searchFilterByService(services: ReceiptServiceType)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateReceipt(savedReceipt: SavedReceipt)

    @Delete
    fun deleteReceipt(savedReceipt: SavedReceipt) */