package com.receipttracker.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(
    tableName = "user_groups",
    indices = arrayOf(
        Index(value = ["group_iad"], unique = true)
    )
)
data class Groups (

    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "group_id")
    val groupId: Int,

    @ColumnInfo(name = "group_name")
    var name: String,

    @ColumnInfo(name = "group_notes")
    var notes: String,

    @ColumnInfo(name = "group_created_at")
    val groupCreatedAt: Int,

    @ColumnInfo(name = "group_updated_at")
    val groupUpdatedAt: Int
)