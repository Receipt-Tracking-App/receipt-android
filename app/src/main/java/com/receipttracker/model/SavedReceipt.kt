package com.receipttracker.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.json.JSONException
import org.json.JSONObject

/*    val price: String,
    val receiptId: Int = 0,
    val date: String,
    val location: String,
    val service: String*/
@Entity(tableName = "receipts")
class SavedReceipt(
    @PrimaryKey(autoGenerate = true)  @ColumnInfo(name = "receipt_id") @NonNull
    var receiptId: Int? = null,
    val dateCreated: Int = 0,
    val dateOfLastUpdate: Int = 0,
    val notes: String = "",
    val merchant: String = "",
    val price: Double = 0.0,
    val date: String = "",
    val location: String = "",
    val receiptServiceType: ReceiptServiceType = ReceiptServiceType.Food
)
//Receipt Media (Picture of the receipt). Has the same primarykey as saved receipt.
@Entity(tableName = "receipt_media")
class ReceiptMedia(
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "receipt_id")
    var receiptId: Int? = null,
    @ColumnInfo(name = "uri")
    var receiptPhotoUri: String,
    @ColumnInfo(name = "description")
    var description: String
)

enum class ReceiptServiceType (service: String) {
    Business("business"),
    Food("food"),
    Shopping("shopping"),
    Travel("travel")
}