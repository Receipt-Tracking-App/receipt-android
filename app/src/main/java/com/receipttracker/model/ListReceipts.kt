package com.receipttracker.model

data class ListReceipts(
    val error: Boolean,
    val receipts: Receipts
) {
    data class Receipts(
        val id: Int,
        val receipts: List<Receipt>
    ) {
        data class Receipt(
            val amount: String,
            val created_at: String,
            val id: Int,
            val media: List<Any>,
            val merchant: String,
            val notes: String,
            val purchase_date: String,
            val updated_at: String,
            val user_id: Int
        )
    }
}