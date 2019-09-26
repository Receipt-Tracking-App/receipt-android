package com.receipttracker.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.receipttracker.ViewModel.common.BaseViewModel
import com.receipttracker.ViewModel.util.RegisterValidation
import com.receipttracker.model.NewUser
import com.receipttracker.model.User

class RegisterViewModel : ViewModel() {

    val newUser: MutableLiveData<NewUser> by lazy {
        MutableLiveData<NewUser>()

    }


    val registerValidation = RegisterValidation()

    fun checkIfValid(email: String?) {
        registerValidation.validate(email)
    }

    fun checkIfValid(name: String?, minLength: Int, maxLength: Int ) {

        registerValidation.validate(name, minLength, maxLength)
    }

    fun createNewUser() {
        registerValidation.createUserForAPI(
            NewUser(
                newUser.value?.firstName,
                newUser.value?.lastName,
                newUser.value?.email,
                newUser.value?.username,
                newUser.value?.password
            )
        )
    }
}



