package com.receipttracker.model

data class ReceiptResponse (val error: Boolean, val message: String, val receiptId: Int, val receipts: List<Receipts>)

//data class ReceiptResponse (val error: Boolean, val message: String, val receiptId: Int)

data class Receipts(val id: Int, var merchant: String, var amount: String, var notes: String, val user_id: Int)