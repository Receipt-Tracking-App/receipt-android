package com.receipttracker.model

import androidx.lifecycle.LiveData

interface ReceiptRepoInterface{

    fun createReceipt(receipt: SavedReceipt)
    fun getAllReceipts(): LiveData<List<SavedReceipt>>
    fun updateReceipt(savedReceipt: SavedReceipt)
    fun deleteReceipt(savedReceipt: SavedReceipt)
}