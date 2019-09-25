package com.receipttracker.model

import androidx.annotation.Size
import androidx.room.*
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import kotlin.math.min


@Entity(
        tableName = "user"
       /* indices = arrayOf(
            Index(
                value = ["id", "user_group_id"],
                unique = true
            )
        ),

        foreignKeys = arrayOf(
        ForeignKey(
            entity = Groups::class,
            parentColumns = arrayOf("group_id"),
            childColumns = arrayOf("user_group_id")
        )
    ) */
)
data class User (

    @ColumnInfo(name = "id") @SerializedName("userId")
    var id: Int,

    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "user_roomId")
    var userRoomId: Int? = null,

    @SerializedName("email")
    val email: String? = null,

    @SerializedName("firstName")
    val firstName: String? = null,

    @SerializedName("lastName")
    val lastName: String? = null,

    @SerializedName("password")
    val password: String? = null,

    //@SerializedName("created_at")
    //val dateUserAccountCreated: Int? = null,

    //@SerializedName("updated_at")
    //val dateUserAccountLastUpdated: Int? = null,

    @ColumnInfo(name = "user_group_id")
    @SerializedName("user_group_id")
    val userGroupId: Int? = null
) : Serializable

class UserLogin (

    @SerializedName("userId")
    val username: String,
    @SerializedName("password")
    val password: String

) : Serializable

class NewUser (

    @SerializedName("firstName")
    val firstName: String?,
    @SerializedName("lastName")
    val lastName: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("username")
    val username: String?,
    @SerializedName("password")
    val password: String?
) : Serializable