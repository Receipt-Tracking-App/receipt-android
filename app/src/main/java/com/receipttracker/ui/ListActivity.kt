package com.receipttracker.ui

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.util.Log
import com.receipttracker.R
import com.receipttracker.ViewModel.ReceiptViewModel
import com.receipttracker.model.*
import com.receipttracker.remote.ServiceBuilder
import androidx.recyclerview.widget.LinearLayoutManager
import com.receipttracker.R
import com.receipttracker.ViewModel.ReceiptViewModel
import com.receipttracker.local.SavedReceiptDao
import com.receipttracker.local.SavedReceiptDao_Impl
import com.receipttracker.model.ReceiptCategories
import com.receipttracker.model.ReceiptOverview
import com.receipttracker.model.SavedReceipt

import com.receipttracker.model.receiptRepo
import com.receipttracker.repository.SavedReceiptsDBERepository

import kotlinx.android.synthetic.main.activity_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.StringBuilder
import java.lang.ref.WeakReference
import retrofit2.http.Body
import java.lang.ref.WeakReference

class ListActivity : AppCompatActivity() {

    companion object{
        val receiptList = mutableListOf<SavedReceipt>()
    }

    lateinit var viewModel: ReceiptViewModel

    val apiBuilder = SavedReceiptsDBERepository(this).apiFactory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)


       // apiBuilder.getUserReceiptsByID(1)
        var itemList = listOf<SavedReceipt>(SavedReceipt(0,
            11,"MCDS", 1.69f, "ghuighsdk",0), SavedReceipt(0, 11/11/1986, "SHOPPING MALL", 200.00f, "horrible experience", 1)
        )
        recycle.apply {
            layoutManager =  LinearLayoutManager(this@ListActivity)
            adapter = ReceiptRecyclerViewAdapter(itemList)
        }

        listActivity_bottomAppBar_fab.setOnClickListener {
            startActivity(Intent(this, AddReceiptActivity::class.java))
        }

        //TODO REPLACE TOKEN AND USERID WHEN LOGIN IS COMPLETE
        val token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsYXN0TmFtZSI6ImNob3ciLCJ1c2VySWQiOjIxLCJpYXQiOjE1Njk1NDM1MzAsImV4cCI6MTU2OTU2NTEzMCwiYXVkIjoiZ2VuZXJhbHB1YmxpYyIsImlzcyI6IlJlY2VpcHRUcmFja2VySW5jIiwic3ViIjoiYXV0aEByZWNlaXB0dHJhY2tlcmluYy5jb20ifQ.cmc-FkZ-PU3MLr2P5HK4C76_EieHv0mOm24ZP8lJKbw"
        val call:Call<ListReceipts> = ServiceBuilder.create().getUserReceiptsByID(token, 21)

        call.enqueue(object: Callback<ListReceipts>{
            override fun onFailure(call: Call<ListReceipts>, t: Throwable) {
                Log.i("onFailure", t?.message)
            }

            override fun onResponse(
                call: Call<ListReceipts>,
                response: Response<ListReceipts>
            ) {
                val currentReceipt = response.body()?.receipts?.receipts

                currentReceipt?.forEach {
                    receiptList.add(SavedReceipt(it.id, it.purchase_date, it.merchant, it.amount.toFloat(), it.notes, it.created_at, it.updated_at, it.user_id))
                }

                var total:String = ""
                receiptList.forEach {
                    total +=it.merchant
                }

                Log.i("onResponse", total)
            }

        })
    }


 //  private fun getReceiptByBusiness(receiptName: String) {
 //      viewModel.receipts




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
    companion object {

        const val NEW_ENTRY_REQUEST = 2

        const val EDIT_ENTRY_REQUEST = 1

    }


}