package com.receipttracker.model

class ReceiptSearchResults(val results: List<ReceiptOverview>)

class ReceiptOverview(
    val price: String,
    val receiptId: Int = 0,
    val date: String,
    val location: String,
    val service: String
)

class Receipt(
    val purchaseDate: String,
    val merchant: String,
    val amount: Double,
    val notes: String = "",
    val tagName: String = "",
    val tagDescription: String = "",
    val categoryId: Int = 1
)