package com.receipttracker.repository

import androidx.lifecycle.LiveData
import com.receipttracker.model.SavedReceipt
import com.receipttracker.repository.common.BaseRepoInterface

interface ReceiptRepoInterface : BaseRepoInterface<SavedReceipt> {

    fun getAllReceipts(): LiveData<List<SavedReceipt>>
}