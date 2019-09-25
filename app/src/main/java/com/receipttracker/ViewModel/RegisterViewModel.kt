package com.receipttracker.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.receipttracker.ViewModel.common.BaseViewModel
import com.receipttracker.model.NewUser
import com.receipttracker.model.User

class RegisterViewModel : BaseViewModel<User>() {

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



    fun validateFirstName(): ValidationWithMessage {

        val user = newUser
        val validationWithMessage =
            when {
                user != null -> when {
                    user.firstName.isNullOrBlank() -> ValidationWithMessage("Field can't be empty", false)
                    user.firstName.length < 2 -> ValidationWithMessage("Must be at leas 2 characters", false)
                    else -> ValidationWithMessage(null, true)
                }
                else -> ValidationWithMessage("Error", false)
            }
        return validationWithMessage
    }

}



data class ValidationWithMessage(val errorText: String?, val valid: Boolean)