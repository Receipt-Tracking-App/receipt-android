package com.receipttracker.local.repository

import androidx.lifecycle.LiveData
import com.receipttracker.model.SavedReceipt

interface ReceiptRepoInterface{

    fun createReceipt(receipt: SavedReceipt)
    fun getAllReceipts(): LiveData<List<SavedReceipt>>
    fun updateReceipt(savedReceipt: SavedReceipt)
    fun deleteReceipt(savedReceipt: SavedReceipt)
}