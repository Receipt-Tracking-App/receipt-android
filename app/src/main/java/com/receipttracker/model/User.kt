package com.receipttracker.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
class User (var user: String,

            @PrimaryKey(autoGenerate = true) @NonNull
            var password: String)