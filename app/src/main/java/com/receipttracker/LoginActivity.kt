package com.receipttracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Move to the list activity.
        btn_login.setOnClickListener {
            //Gets the text from the username edit text
            var username = text_input_username.editText?.text.toString().trim()

            //Gets the text from the password edit text
            var password = text_input_password.editText?.text.toString().trim()
            Toast.makeText(this, "Username: $username\nPassword: $password", Toast.LENGTH_SHORT).show()

            //If username and password match to a user in the database, move to the list activity
            startActivity(Intent(this, ListActivity::class.java))
        }

        //Move to the register activity when the register button is clicked on
        btn_register.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }


    }
}
