package com.receipttracker.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.receipttracker.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Move to the register activity when the register button is clicked on
        btn_register.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

    }
}