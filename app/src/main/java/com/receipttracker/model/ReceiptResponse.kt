package com.receipttracker.model

class ReceiptResponse (val error: Boolean, val message: String, val receiptId: Int)

//data class ReceiptResponse (val error: Boolean, val message: String, val receiptId: Int)

data class ReceiptResponseInGet(val error: Boolean, val receipts: List<Receipts>)
data class Receipts(val id: Int)