package com.receipttracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private var validatedFirstName: Boolean = false
    private var validatedLastName: Boolean = false
    private var validatedUsername: Boolean = false
    private var validatedEmail: Boolean = false
    private var validatedPassword: Boolean = false

    //Making these variables global since they're probably gonna be needed when working with the database
    lateinit var firstName: String
    lateinit var lastName: String
    lateinit var username: String
    lateinit var email: String
    lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register_create.setOnClickListener {
            validateFirstName()
            validateLastName()
            validateUsername()
            validateEmail()
            validatePassword()
            confirmRegister()
        }

        btn_cancel_registration.setOnClickListener {
            finish()
        }

    }

    //Checks to see if the entered first name is okay or not.
    private fun validateFirstName():Boolean{
        //Gets the text from the firstName text input layout
        firstName = text_input_first_name_register.editText?.text.toString().trim()

        if(firstName.isEmpty()){
            text_input_first_name_register.error = "Field can't be empty"
            validatedFirstName = false
            return false
        }
        else{
            //Removes the error message if it already exists
            text_input_first_name_register.error = null
            text_input_first_name_register.isErrorEnabled = false
            validatedFirstName= true
            return true
        }
    }

    //Checks to see if the entered last name is okay or not.
    private fun validateLastName():Boolean{
        //Gets the text from the lastName text input layout
        lastName = text_input_last_name_register.editText?.text.toString().trim()

        if(lastName.isEmpty()){
            text_input_last_name_register.error = "Field can't be empty"
            validatedLastName = false
            return false
        }
        else{
            //Removes the error message if it already exists
            text_input_last_name_register.error = null
            text_input_last_name_register.isErrorEnabled = false
            validatedLastName= true
            return true
        }
    }

    //Checks to see if the entered username is okay or not.
    private fun validateUsername():Boolean{
        //Gets the text from the username text input layout
        username = text_input_username_register.editText?.text.toString().trim()

        if(username.isEmpty()){
            text_input_username_register.error = "Field can't be empty"
            validatedUsername = false
            return false
        }
        else{
            //Removes the error message if it already exists
            text_input_username_register.error = null
            text_input_username_register.isErrorEnabled = false
            validatedUsername = true
            return true
        }
    }

    //Checks to see if the entered email is okay or not.
    private fun validateEmail():Boolean{
        //Gets the text from the email text input layout
        email = text_input_email_register.editText?.text.toString().trim()

        if(email.isEmpty()){
            text_input_email_register.error = "Field can't be empty"
            validatedEmail = false
            return false
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            text_input_email_register.error = "Invalid Email Format"
            return false
        }
        else{
            //Removes the error message if it already exists
            text_input_email_register.error = null
            text_input_email_register.isErrorEnabled = false
            validatedEmail = true
            return true
        }
    }

    //Checks to see if the entered password is okay or not.
    private fun validatePassword():Boolean{
        //Gets the text from the password text input layout
        password = text_input_password_register.editText?.text.toString().trim()

        if(password.isEmpty()){
            text_input_password_register.error = "Field can't be empty"
            validatedPassword = false
            return false
        }
        else{
            //Removes the error message if it already exists
            text_input_password_register.error = null
            text_input_password_register.isErrorEnabled = false
            validatedPassword = true
            return true
        }
    }

    //Checks to see if all the fields are correct or not. If so, return back to the login page.
    private fun confirmRegister(){
        //If any of the entered information isn't entered properly, prevent the user from successfully registering.
        if (!validatedFirstName || !validatedLastName || !validatedUsername || !validatedEmail || !validatedPassword)
            return

        finish()
    }
}
