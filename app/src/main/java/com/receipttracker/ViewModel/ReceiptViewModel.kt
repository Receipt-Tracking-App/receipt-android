package com.receipttracker.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.receipttracker.model.SavedReceipt
import com.receipttracker.model.repo

class ReceiptViewModel : ViewModel(){

    val receipts: LiveData<List<SavedReceipt>> by lazy {

        readAllReceipts()
    }
    fun readAllReceipts() : LiveData<List<SavedReceipt>>{

        return repo.readAllReceipts()
    }
    fun createReceipt(receipt: SavedReceipt){
        repo.createReceipt((receipt))
    }



    fun updateReceipt(receipt: SavedReceipt){
        repo.updateReceipt(receipt)
    }
    fun deleteReceipt(receipt: SavedReceipt){
        repo.deleteReceipt(receipt)
    }

}