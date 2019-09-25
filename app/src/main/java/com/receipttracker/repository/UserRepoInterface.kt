package com.receipttracker.repository

import androidx.lifecycle.LiveData
import com.receipttracker.model.User
import com.receipttracker.repository.common.BaseRepoInterface

interface UserRepoInterface : BaseRepoInterface<User> {

    fun getUserData(id: String): LiveData<User>

    fun loginUser(user: User)

    fun nukeUserTable()
}