package com.receipttracker.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.receipttracker.local.AppDB
import com.receipttracker.model.User
import com.receipttracker.remote.ReceiptTrackerService
import com.receipttracker.repository.common.BaseRepoInterface

class UserDBRepository(val context: Context) : UserRepoInterface {



    private val database = AppDB.getDatabase(context)
    private val apiFactory = apiFactory()


    override fun apiFactory(): ReceiptTrackerService {
        return super.apiFactory()
    }

    // Room
    override fun getUserData(id: String): LiveData<User> {
        return database.userDao().getUserData(id)
    }

    override fun create(obj: User) {
        database.userDao().insert(obj)
    }

    override fun update(obj: User) {
        database.userDao().update(obj)
    }

    override fun delete(obj: User) {
        database.userDao().delete(obj)
    }
    // Retrofit
    override fun loginUser(userId: String, password: String) {
        apiFactory.userLoginPost(userId, password)
    }


}