package com.receipttracker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.receipttracker.R
import com.receipttracker.ViewModel.RegisterViewModel
import com.receipttracker.ViewModel.util.RegisterValidation
import com.receipttracker.ViewModel.util.ValidationWithMessage
import com.receipttracker.model.NewUser
import com.receipttracker.model.RegisterResponse
import com.receipttracker.remote.ReceiptTrackerService
import com.receipttracker.remote.ServiceBuilder
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var model: RegisterViewModel
    val registerValidation = RegisterValidation()

    companion object{
        var token = ""
    }


    //
    //Making these variables global since they're probably gonna be needed when working with the database


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        model = ViewModelProviders.of(this).get(RegisterViewModel::class.java)


        btn_register_create.setOnClickListener {

            val firstNameText = text_input_first_name_register.editText.toString().trim()
            val firstNameValidation = registerValidation.validate(firstNameText,RegisterValidation.NAME_AND_USERNAME_MIN_LENGTH, RegisterValidation.NAME_AND_USERNAME_MAX_LENTH)

            val lastNameText = text_input_last_name_register.editText.toString().trim()
            val lastNamevalidation = registerValidation.validate(lastNameText,RegisterValidation.NAME_AND_USERNAME_MIN_LENGTH, RegisterValidation.PASSWORD_MAX_LENGTH)

            val userNameText = text_input_username_register.editText.toString().trim()
            val userNameValidation = registerValidation.validate(userNameText,RegisterValidation.NAME_AND_USERNAME_MIN_LENGTH, RegisterValidation.NAME_AND_USERNAME_MAX_LENTH)

            val passwordText = text_input_password_register.editText.toString().trim()
            val passwordValidation = registerValidation.validate(passwordText, RegisterValidation.PASSWORD_MIN_LENGTH, RegisterValidation.PASSWORD_MAX_LENGTH)

            val emailText = text_input_email_register.editText.toString().trim()
            val emailValidation = registerValidation.validate(emailText)

            val validations = listOf(
                firstNameValidation,
                lastNamevalidation,
                userNameValidation,
                passwordValidation,
                emailValidation
            )

            if (validations.all { it.isValid() }) {
                model.newUser.value?.apply {

                    firstName = firstNameText
                    lastName = lastNameText
                    username = userNameText
                    password = passwordText
                    email = emailText
                }
                model.createNewUser()
            } else {
                text_input_first_name_register.error = firstNameValidation.errorText
                text_input_last_name_register.error = lastNamevalidation.errorText
                text_input_username_register.error = userNameValidation.errorText
                text_input_email_register.error = emailValidation.errorText
                text_input_password_register.error = passwordValidation.errorText
            }
           /* Toast.makeText(
                this,
                "New User successfully created\nWelcome ${model.newUser.value?.lastName}",
                Toast.LENGTH_SHORT
            ).show() */
        }

        btn_cancel_registration.setOnClickListener {
            finish()
        }
    }
}


