package com.receipttracker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.util.Log
import com.receipttracker.R
import com.receipttracker.model.Receipt
import com.receipttracker.model.ReceiptOverview
import com.receipttracker.model.ReceiptResponse
import com.receipttracker.model.SavedReceipt
import com.receipttracker.remote.ReceiptTrackerService
import com.receipttracker.remote.ServiceBuilder
import kotlinx.android.synthetic.main.activity_add_receipt.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddReceiptActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_receipt)

        //Opens up the fragment to allow the user to pick a date
        btn_date.setOnClickListener {
            val fragment = DateFragment()
            fragment.show(supportFragmentManager, "datePicker")
        }

        //Adds the receipt
        btn_add_receipt_confirm.setOnClickListener {

            Log.i("on", "Test")

            val date = text_purchase_date_add.editText?.text.toString().trim()
            val merchant = text_merchant_add.editText?.text.toString().trim()
            val cost = text_amount_add.editText?.text.toString().toDouble()
            val description = text_notes_add.editText?.text.toString().trim()

            Log.i("onBefore", "Test")

            val call: Call<ReceiptResponse> = ServiceBuilder.create().createNewReceipt(
                Receipt(date, merchant, cost, description))

            Log.i("onAfter", "Test")

            call.enqueue(object: Callback<ReceiptResponse>{
                override fun onFailure(call: Call<ReceiptResponse>, t: Throwable) {
                    Log.i("onFailure", t?.message)
                }

                override fun onResponse(
                    call: Call<ReceiptResponse>,
                    response: Response<ReceiptResponse>
                ) {
                    Log.i("onResponse", "PLEASE CONNECT")
                }

            })
            finish()
        }
    }
}

/*
        call.enqueue(object: Callback<RegisterResponse>{
            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Log.i("OnFailure", t.message)
            }

            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                token = response.body()!!.token
                Log.i("onRespone", token)
            }
        })
 */