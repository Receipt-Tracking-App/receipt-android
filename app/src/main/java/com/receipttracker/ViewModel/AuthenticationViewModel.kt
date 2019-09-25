package com.receipttracker.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.receipttracker.ViewModel.common.BaseViewModel
import com.receipttracker.model.User
import com.receipttracker.model.UserLogin
import com.receipttracker.model.userRepo

class AuthenticationViewModel: BaseViewModel<User>() {

    var user: LiveData<User>? = null

    fun getUser(userId: Int) {
        val loggedInUser = userRepo.getUserData(userId)
        user = loggedInUser
    }

    override fun create(obj: User) {
        userRepo.create(obj)
    }

    override fun update(obj: User) {
        userRepo.update(obj)
    }

    override fun delete(obj: User) {
        userRepo.delete(obj)
    }

    // Login and Sign Out
    fun loginUser(userLogin: UserLogin) {
        userRepo.loginUser(userLogin)
    }

    fun nukeUserTableOnSignOut() {
        userRepo.nukeUserTable()
        user = null
    }




}