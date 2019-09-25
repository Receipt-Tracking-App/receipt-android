package com.receipttracker.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.receipttracker.local.AppDB
import com.receipttracker.model.User
import com.receipttracker.remote.ReceiptTrackerService
import com.receipttracker.repository.common.BaseRepoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
    override fun nukeUserTable() {
        database.userDao().nukeUserTable()
    }

    // Retrofit
    override fun loginUser(user: User) {

        apiFactory.userLoginPost(user).enqueue(object: Callback<User> {

            override fun onFailure(call: Call<User>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful && response.body() != null) {

                    //val userId
                }
            }

        })
    }


}