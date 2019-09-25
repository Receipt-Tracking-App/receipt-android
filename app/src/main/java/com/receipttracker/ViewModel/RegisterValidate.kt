package com.receipttracker.ViewModel

class RegisterValidation {
    companion object {
        const val BLANK_ERROR_TEXT = "Field can't be empty"
        fun characterLengthErrorText(maxLength: Int, minLength: Int, tooLong: Boolean) : String {

            return when(tooLong) {
                true -> "Must be at less than $maxLength characters"
                else -> "Must be at least $minLength characters long."
            }

        }


    }
    fun validateName(name: String?, requiredNameLength: Int): ValidationWithMessage {

        return when {
            name != null -> when {
                name.isNotBlank() -> ValidationWithMessage(BLANK_ERROR_TEXT,false)
                name.length < requiredNameLength -> ValidationWithMessage("Must be at leas 2 characters", false)
                else -> ValidationWithMessage(null, true)
            }
            else -> ValidationWithMessage("Error", false)
        }
    }
    fun validateUsername(username: String?, requiredUsernameLength: Int) : ValidationWithMessage {
        return when {
            username != null -> when {
                username.isNotBlank() -> ValidationWithMessage("Field can")
            }
        }
    }
}