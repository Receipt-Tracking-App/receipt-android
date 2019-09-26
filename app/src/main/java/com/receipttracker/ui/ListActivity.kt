package com.receipttracker.ui

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.receipttracker.R
import com.receipttracker.ViewModel.ReceiptViewModel
import com.receipttracker.model.Receipt
import com.receipttracker.model.ReceiptOverview
import com.receipttracker.model.ReceiptResponse
import com.receipttracker.model.SavedReceipt
import com.receipttracker.remote.ServiceBuilder
import kotlinx.android.synthetic.main.activity_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.ref.WeakReference

class ListActivity : AppCompatActivity() {

    lateinit var viewModel: ReceiptViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        listActivity_bottomAppBar_fab.setOnClickListener {
            startActivity(Intent(this, AddReceiptActivity::class.java))
        }

        //TODO REPLACE TOKEN AND USERID WHEN LOGIN IS COMPLETE
        val token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsYXN0TmFtZSI6ImNob3ciLCJ1c2VySWQiOjIxLCJpYXQiOjE1Njk1MTk0NjAsImV4cCI6MTU2OTU0MTA2MCwiYXVkIjoiZ2VuZXJhbHB1YmxpYyIsImlzcyI6IlJlY2VpcHRUcmFja2VySW5jIiwic3ViIjoiYXV0aEByZWNlaXB0dHJhY2tlcmluYy5jb20ifQ.aWVyRUv47RYbK47vzmEhrAzEWd4YV2r4Do2CtT0tm4w"
        val call:Call<SavedReceipt> = ServiceBuilder.create().getUserReceiptsByID(token, 21)

        call.enqueue(object: Callback<SavedReceipt>{
            override fun onFailure(call: Call<SavedReceipt>, t: Throwable) {
                Log.i("onFailure", t?.message)
            }

            override fun onResponse(
                call: Call<SavedReceipt>,
                response: Response<SavedReceipt>
            ) {
                Log.i("onResponse", "PLEASE CONNECT")
            }

        })
    }

    private fun getReceiptByBusiness(receiptName: String) {
        viewModel.receipts

    }

    class CreateAsyncTask(viewModel: ReceiptViewModel) : AsyncTask<SavedReceipt, Void, Unit>() {
        private val viewModel = WeakReference(viewModel)
        override fun doInBackground(vararg p0: SavedReceipt?) {
            if (p0.isNotEmpty()) {
                p0[0]?.let {
                    //viewModel.get()?.createReceipt(it)
                }

            }

        }
    }
}