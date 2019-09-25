package com.receipttracker.ViewModel

import com.receipttracker.ViewModel.common.BaseViewModel
import com.receipttracker.model.NewUser
import com.receipttracker.model.User

class RegisterViewModel : BaseViewModel<User>() {

    val registerValidation = RegisterValidation
    val newUser: NewUser? = null

    override fun create(obj: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(obj: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(obj: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }







}



