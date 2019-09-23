package com.receipttracker.model

class ReceiptSearchResults(val results: List<ReceiptOverview>)

class ReceiptOverview(
    val price: String,
    val receiptId: Int = 0,
    val date: String,
    val location: String,
    val service: String
)