package com.receipttracker.ViewModel

import android.util.Log
import android.util.Patterns
import com.receipttracker.model.NewUser
import com.receipttracker.model.RegisterResponse
import com.receipttracker.remote.ServiceBuilder
import com.receipttracker.ui.RegisterActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface RegisterValidation {

    companion object {
        const val EMAIL_FORMAT_ERROR_TEXT = "Invalid email format."
        const val BLANK_ERROR_TEXT = "Field can't be empty."
        fun characterLengthErrorText(maxLength: Int, minLength: Int, tooLong: Boolean = false) : String {

            return when(tooLong) {
                true -> "Must be at less than $maxLength characters"
                else -> "Must be at least $minLength characters long."
            }

        }
    }

    fun validateString(name: String?, minLength: Int, maxLength: Int): ValidationWithMessage {

        return when {

                name.isNullOrBlank() -> ValidationWithMessage(BLANK_ERROR_TEXT,false)
                name.length < minLength -> ValidationWithMessage(characterLengthErrorText(maxLength, minLength, false), false)
                name.length > maxLength -> ValidationWithMessage(characterLengthErrorText(maxLength,minLength,true), false)
                else -> ValidationWithMessage(null, true)
            }
    }

    fun validateEmail(email: String?): ValidationWithMessage {

        return when {
            email.isNullOrBlank() -> ValidationWithMessage(BLANK_ERROR_TEXT, false)
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> ValidationWithMessage(EMAIL_FORMAT_ERROR_TEXT, false)
            else -> ValidationWithMessage(BLANK_ERROR_TEXT, false)
        }
    }

    fun confirmRegister(newUser: NewUser) {

        val firstNameValidationReturn = newUser.firstName
        val lastNameValidationReturn = newUser.lastName
        val usernameValidationReturn = newUser.username
        val emailValidationReturn = newUser.email
        val passwordValidationReturn = newUser.password

    }

    fun createUserForAPI(newUser: NewUser) {
        val call: Call<RegisterResponse> = ServiceBuilder.create().createUser(newUser)

        call.enqueue(object: Callback<RegisterResponse> {
            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Log.i("OnFailure", t.message)
            }

            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                RegisterActivity.token = response.body()!!.token
                Log.i("onRespone", RegisterActivity.token)
            }
        })
    }


}
data class ValidationWithMessage(val errorText: String?, val valid: Boolean)