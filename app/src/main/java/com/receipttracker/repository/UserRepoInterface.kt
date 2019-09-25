package com.receipttracker.repository

import androidx.lifecycle.LiveData
import com.receipttracker.model.User
import com.receipttracker.model.UserLogin
import com.receipttracker.repository.common.BaseRepoInterface

interface UserRepoInterface : BaseRepoInterface<User> {

    fun getUserData(id: Int): LiveData<User>

    fun loginUser(user: UserLogin)

    fun nukeUserTable()

    fun deleteOldUsers()
}