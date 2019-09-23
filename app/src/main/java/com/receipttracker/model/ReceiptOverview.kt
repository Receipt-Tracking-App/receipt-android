package com.receipttracker.model

class ReceiptSearchResults(val results: List<ReceiptOverview>)

class ReceiptOverview(
    val receiptTitle: String,
    val receiptId: Int = 0
)