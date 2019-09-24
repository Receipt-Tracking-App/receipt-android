package com.receipttracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity() {

    private var validatedUsername: Boolean = false
    private var validatedPassword: Boolean = false

    //Making these variables global since they're probably gonna be needed when checking the database
    lateinit var username: String
    lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Move to the list activity if username and password are good
        btn_login.setOnClickListener {

            validateUsername()
            validatePassword()
            confirmLogin()

        }

        //Move to the register activity when the register button is clicked on
        btn_register.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }
        btn_login.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }

        //Allows us to move to the ListActivity without a legit account
        //TODO Remove this on official release
        btn_dev_skip.setOnClickListener {
            startActivity(Intent(this, ListActivity::class.java))
        }
    }

    //Checks to see if the entered username is okay or not.
    private fun validateUsername():Boolean{
        //Gets the text from the username text input layout
        username = text_input_username.editText?.text.toString().trim()

        if(username.isEmpty()){
            text_input_username.error = "Field can't be empty"
            validatedUsername = false
            return false
        }
        else{
            //Removes the error message if it already exists
            text_input_username.error = null
            text_input_username.isErrorEnabled = false
            validatedUsername = true
            return true
        }
    }

    //Checks to see if the entered password is okay or not.
    private fun validatePassword():Boolean{
        //Gets the text from the password text input layout
        password = text_input_password.editText?.text.toString().trim()

        if(password.isEmpty()){
            text_input_password.error = "Field can't be empty"
            validatedPassword = false
            return false
        }
        else{
            //Removes the error message if it already exists
            text_input_password.error = null
            text_input_password.isErrorEnabled = false
            validatedPassword = true
            return true
        }
    }

    //Checks to see if both login and password are correct. If so, move to ListActivity.
    private fun confirmLogin(){
        //If either the username or password is incorrect, prevent logging in.
        //For some reason, doing if(!validateUsername() || !validatePassword()) messes up the error message)
        if (!validatedUsername || !validatedPassword)
            return

        startActivity(Intent(this, ListActivity::class.java))
    }

    override fun onPostResume() {
        text_input_username.error = null
        text_input_username.isErrorEnabled = false

        text_input_password.error = null
        text_input_password.isErrorEnabled = false

        super.onPostResume()
    }
}
