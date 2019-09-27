package com.receipttracker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.util.Log
import android.widget.Toast
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

    private var validatedDate: Boolean = false
    private var validatedMerchant: Boolean = false
    private var validatedCost: Boolean = false

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

            validateDate()
            validateMerchant()
            validateCost()
            confirmAddReceipt()
        }
    }

    private fun validateDate(): Boolean{
        if(text_purchase_date_add.editText?.text.isNullOrBlank()) {
            text_purchase_date_add.error = "Please enter a valid date in the format YYYY-MM-DD\nOr use the date picker below"
            validatedDate = false
            return false
        }
        else{
            text_purchase_date_add.error = null
            text_purchase_date_add.isErrorEnabled = false
            validatedDate = true
            return true
        }
    }

    private fun validateMerchant(): Boolean{
        if(text_merchant_add.editText?.text.isNullOrBlank()) {
            text_merchant_add.error = "Seller cannot be empty"
            validatedMerchant = false
            return false
        }
        else{
            text_merchant_add.error = null
            text_merchant_add.isErrorEnabled = false
            validatedMerchant = true
            return true
        }
    }

    private fun validateCost(): Boolean{
        if(text_amount_add.editText?.text.isNullOrBlank()) {
            text_amount_add.error = "Cost cannot be empty"
            validatedCost = false
            return false
        }
        else{
            text_amount_add.error = null
            text_amount_add.isErrorEnabled = false
            validatedCost = true
            return true
        }
    }

    private fun confirmAddReceipt(){

        if(!validatedDate || !validatedMerchant || !validatedCost)
            return

        val date = text_purchase_date_add.editText?.text.toString().trim()
        val merchant = text_merchant_add.editText?.text.toString().trim()
        val cost = text_amount_add.editText?.text.toString().toDouble()
        val description = text_notes_add.editText?.text.toString().trim()

        val call: Call<ReceiptResponse> = ServiceBuilder.create().createNewReceipt(LoginActivity.token,
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

        Toast.makeText(this, "Receipt has been added successfully", Toast.LENGTH_SHORT).show()
        finish()
    }
}