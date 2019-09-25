package com.receipttracker.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import com.receipttracker.local.common.BaseDao
import com.receipttracker.model.User

@Dao
abstract class UserDao : BaseDao<User> {

    //We only really need one user table since we're only syncing the room database with the API. So...Nuke It!
    @Query("DELETE FROM user")
    abstract fun nukeUserTable()

    @Query("SELECT * FROM user WHERE id = :userId")
    abstract fun getUserData(userId: String): LiveData<User>
}