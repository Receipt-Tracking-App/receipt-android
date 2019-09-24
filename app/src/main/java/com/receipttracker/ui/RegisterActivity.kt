package com.receipttracker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.receipttracker.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register_create.setOnClickListener {
            finish()
        }

    }
}
