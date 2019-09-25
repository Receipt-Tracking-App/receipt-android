package com.receipttracker.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.receipttracker.local.common.BaseDao
import com.receipttracker.model.User

@Dao
abstract class UserDao : BaseDao<User> {

    @Query("SELECT * FROM user WHERE id = :userId")
    abstract fun getUserData(userId: String): LiveData<User>
}