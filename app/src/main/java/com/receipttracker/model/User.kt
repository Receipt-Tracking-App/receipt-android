package com.receipttracker.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
class User (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "first_name")
    val firstName: String,
    @ColumnInfo(name = "last_name")
    val lastName: String,
    @ColumnInfo(name = "username")
    val username: String,
    @ColumnInfo(name = "date_user_account_create")
    val dateUserAccountCreated: Int? = null,
    @ColumnInfo(name= "date_user_account_last_updated")
    val dateUserAccountLastUpdated: Int? = null
)