package com.receipttracker.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "tags"

    /* foreignKeys = arrayOf(

        ForeignKey(
            entity = SavedReceipt::class,
            parentColumns = ["receipt_id"],
            childColumns = ["tags_receipt_id"]
        ),
        ForeignKey(
            entity = ReceiptCategories::class,
            parentColumns = ["id"],
            childColumns = ["receipt_category_id"]
        )
    ) */
)
class Tags (

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    @ColumnInfo(name = "receipt_category_id")
    val receiptCategoryId: Int,

    @ColumnInfo(name = "tags_receipt_id")
    val receiptId: Int,

    val name: String,

    val description: String
)

@Entity(
    tableName = "receipt_categories"

    /*    foreignKeys = arrayOf(
        ForeignKey(
            entity = ReceiptMainCategories::class,
            parentColumns = ["id"],
            childColumns = ["receipt_main_categories_id"]
        )
    ) */
)

class ReceiptCategories (

    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")
    val id: Int? = null,

    val name: String,

    @ColumnInfo(name = "receipt_main_categories_id")
    val receiptMainCategoriesId: Int
)

@Entity(
    tableName = "receipt_main_categories"
)
class ReceiptMainCategories(

    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")
    val id: Int? = null,

    val name: String,

    val description: String
)