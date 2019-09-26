package com.receipttracker.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.receipttracker.model.User
import com.receipttracker.model.UserLogin
import com.receipttracker.model.userRepo
import okhttp3.internal.userAgent

class LoginViewModel : ViewModel(){

    fun createUser(user: User){
        userRepo.create(user)
    }
    fun loginUser(user: UserLogin){
        userRepo.loginUser(user)
    }



    fun updateUpdateUser(user: User){
        userRepo.create(user)
    }
    fun deleteUser(user: User){
        userRepo.nukeUserTable()
    }
}
