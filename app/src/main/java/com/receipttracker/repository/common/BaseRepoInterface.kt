package com.receipttracker.repository.common

import com.receipttracker.remote.ServiceBuilder
import com.receipttracker.remote.ReceiptTrackerService

interface BaseRepoInterface<T> {

    fun apiFactory(): ReceiptTrackerService {
        val receiptTrackerFactory by lazy {
            ServiceBuilder.create()
        }
        return receiptTrackerFactory
    }

    fun create(obj: T)

    fun update(obj: T)

    fun delete(obj: T)
}