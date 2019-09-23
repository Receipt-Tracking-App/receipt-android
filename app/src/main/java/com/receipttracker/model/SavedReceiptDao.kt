package com.receipttracker.model

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface SavedReceiptDao{


    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun createReceipt(savedReceipt: SavedReceipt)

    @Query("select * from SavedReceipt")
    fun readAllReceipts(): LiveData<List<SavedReceipt>>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateReceipt(savedReceipt: SavedReceipt)

    @Delete

    fun deleteReceipt(savedReceipt: SavedReceipt)


}