package com.receipttracker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import com.receipttracker.R
import kotlinx.android.synthetic.main.activity_add_receipt.*

class AddReceiptActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_receipt)

        btn_date.setOnClickListener {
            val fragment = DateFragment()
            fragment.show(supportFragmentManager, "datePicker")
        }
    }
}
