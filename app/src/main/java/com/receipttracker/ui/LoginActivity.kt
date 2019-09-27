package com.receipttracker.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.receipttracker.R
import com.receipttracker.model.LoginResponse
import com.receipttracker.model.UserLogin
import com.receipttracker.remote.ServiceBuilder
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private var validatedUsername: Boolean = false
    private var validatedPassword: Boolean = false
    private var error: Boolean? = false

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
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        //Allows us to move to the ListActivity without a legit account
        //TODO Remove this on official release
        btn_dev_skip.setOnClickListener {
            startActivity(Intent(this, ListActivity::class.java))
        }
    }

    //Checks to see if the entered username is okay or not.
    private fun validateUsername(): Boolean {
        //Gets the text from the username text input layout
        username = text_input_username.editText?.text.toString().trim()

        if (username.isEmpty()) {
            text_input_username.error = "Field can't be empty"
            validatedUsername = false
            return false
        } else if (username.length < 4) {
            text_input_username.error = "Username should be at least four characters"
            return false
        } else if (username.length > 12) {
            text_input_username.error = "Username can't be more than 12 characters"
            return false
        } else {
            //Removes the error message if it already exists
            text_input_username.error = null
            text_input_username.isErrorEnabled = false
            validatedUsername = true
            return true
        }
    }

    //Checks to see if the entered password is okay or not.
    private fun validatePassword(): Boolean {
        //Gets the text from the password text input layout
        password = text_input_password.editText?.text.toString().trim()

        if (password.isEmpty()) {
            text_input_password.error = "Field can't be empty"
            validatedPassword = false
            return false
        } else if (password.length < 4) {
            text_input_password.error = "Password should be at least four characters"
            return false
        } else if (password.length > 12) {
            text_input_password.error = "Password can't be more than 12 characters"
            return false
        } else {
            //Removes the error message if it already exists
            text_input_password.error = null
            text_input_password.isErrorEnabled = false
            validatedPassword = true
            return true
        }
    }

    //Checks to see if both login and password are correct. If so, move to ListActivity.
    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    private fun confirmLogin() {
        //If either the username or password is incorrect, prevent logging in.
        //For some reason, doing if(!validateUsername() || !validatePassword()) messes up the error message)
        if (!validatedUsername || !validatedPassword)
            return

        val call: Call<LoginResponse> = ServiceBuilder.create().userLoginPost(UserLogin(username, password))

        call.enqueue(object:Callback<LoginResponse>{
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                //Log.i("onFailure", t.message)
                return
            }

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                error = response.body()?.error
                Log.i("onResponsee", response.body()?.error.toString())

                if(error == false){
                    text_input_username.error = null
                    text_input_password.error = null
                    startActivity(Intent(this@LoginActivity, ListActivity::class.java))
                }
                else{
                    text_input_username.error = "Either Invalid Username or Password"
                    text_input_password.error = "Either Invalid Username or Password"
                }
            }
        })
    }

    //Removes the error messages when moving into the login activity
    override fun onPostResume() {
        text_input_username.error = null
        text_input_username.isErrorEnabled = false

        text_input_password.error = null
        text_input_password.isErrorEnabled = false

        super.onPostResume()
    }
}
/*
        val call: Call<ReceiptResponse> = ServiceBuilder.create().createNewReceipt(token,
            Receipt(date, merchant, cost, description))


        call.enqueue(object: Callback<ReceiptResponse>{
            override fun onFailure(call: Call<ReceiptResponse>, t: Throwable) {
                Log.i("onFailure", t?.message)
            }

            override fun onResponse(
                call: Call<ReceiptResponse>,
                response: Response<ReceiptResponse>
            ) {
                val message = response.body()!!.message
                Log.i("onResponse", message)
            }

        })
 */
