package com.receipttracker.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.receipttracker.model.SavedReceipt
import com.receipttracker.model.receiptRepo

class ReceiptViewModel : ViewModel(){

    val receipts: LiveData<List<SavedReceipt>> by lazy {

        readAllReceipts()
    }
    fun readAllReceipts() : LiveData<List<SavedReceipt>>{

        return receiptRepo.getAllReceipts()
    }
    fun createReceipt(receipt: SavedReceipt){
        receiptRepo.create(receipt)
    }



    fun updateReceipt(receipt: SavedReceipt){
        receiptRepo.update(receipt)
    }
    fun deleteReceipt(receipt: SavedReceipt){
        receiptRepo.delete(receipt)
    }

}