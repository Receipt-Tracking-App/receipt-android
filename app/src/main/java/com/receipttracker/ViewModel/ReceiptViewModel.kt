package com.receipttracker.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.receipttracker.ViewModel.common.BaseViewModel
import com.receipttracker.model.SavedReceipt
import com.receipttracker.model.receiptRepo

class ReceiptViewModel : BaseViewModel<SavedReceipt>() {

    val receipts: LiveData<List<SavedReceipt>> by lazy {

        readAllReceipts()
    }


    override fun create(obj: SavedReceipt) {
        receiptRepo.create(obj)
    }

    override fun update(obj: SavedReceipt) {
        receiptRepo.update(obj)
    }

    override fun delete(obj: SavedReceipt) {
        receiptRepo.delete(obj)
    }


    fun readAllReceipts() : LiveData<List<SavedReceipt>>{

        return receiptRepo.getAllReceipts()
    }

}