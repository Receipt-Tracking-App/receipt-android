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

    companion object{
        var token = ""
    }

    private var validatedFirstName: Boolean = false
    private var validatedLastName: Boolean = false
    private var validatedUsername: Boolean = false
    private var validatedEmail: Boolean = false
    private var validatedPassword: Boolean = false

    //
    //Making these variables global since they're probably gonna be needed when working with the database


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        model = ViewModelProviders.of(this).get(RegisterViewModel::class.java)

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

    //Checks to see if all the fields are correct or not. If so, return back to the login page.
    private fun confirmRegister() {
        //If any of the entered information isn't entered properly, prevent the user from successfully registering.
        if (!validatedFirstName || !validatedLastName || !validatedUsername || !validatedEmail || !validatedPassword)
            return

        Toast.makeText(
            this,
            "New User successfully created\nWelcome $firstName",
            Toast.LENGTH_SHORT
        ).show()
        createUserr()
        finish()
    }

    private fun createUserr(){

    }
}


