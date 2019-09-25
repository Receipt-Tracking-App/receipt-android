package com.receipttracker.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import com.receipttracker.local.common.BaseDao
import com.receipttracker.model.User
import retrofit2.http.DELETE
import java.nio.file.Files.delete
import android.content.ContentResolver
import androidx.annotation.Size
import androidx.room.Update


@Dao
abstract class UserDao : BaseDao<User> {

    @Query("SELECT * FROM user")
    abstract fun getAllStoredUsers() : List<User>
    //We only really need one user table since we're only syncing the room database with the API. So...Nuke It!
    @Query("DELETE FROM user")
    abstract fun nukeUserTable()

    @Query("SELECT * FROM user WHERE id = :userId")
    abstract fun getUserData(userId: Int): LiveData<User>

    @Query("DELETE FROM user where user_roomId NOT IN (SELECT user_roomId from user ORDER BY user_roomId DESC LIMIT 3)")
    abstract fun deleteOldUsers()
}