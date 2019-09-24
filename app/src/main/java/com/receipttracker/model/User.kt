package com.receipttracker.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = "user",
    foreignKeys = arrayOf(
        ForeignKey(
            entity = User:: class,
            parentColumns = arrayOf("groupId"),
            childColumns = arrayOf("userGroupId")
        )
    )
)
data class User (

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @SerializedName("first_name")
    val firstName: String,

    @SerializedName("last_name")
    val lastName: String,

    @SerializedName("username")
    val username: String,

    @SerializedName("date_created")
    val dateUserAccountCreated: Int? = null,

    @SerializedName("date_last_updated")
    val dateUserAccountLastUpdated: Int? = null,

    @SerializedName("user_groupID")
    val userGroupID: Int? = null
)

@Entity(tableName = "user_groups")
data class UserGroups (

    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "group_id")
    val groupId: String,

    @ColumnInfo(name = "group_name")
    var name: String,

    @ColumnInfo(name = "group_notes")
    var notes: String
)