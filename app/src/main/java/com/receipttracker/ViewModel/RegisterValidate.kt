package com.receipttracker.ViewModel

import android.util.Patterns

class RegisterValidation {
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
                name.length < minLength -> ValidationWithMessage("Must be at leas 2 characters", false)
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

    fun confirmRegister() {

    }


}