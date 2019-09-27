package com.receipttracker.ui

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.util.Log

//

import androidx.lifecycle.ViewModelProviders
import com.receipttracker.R
import com.receipttracker.ViewModel.ReceiptViewModel

//

import com.receipttracker.model.*
import com.receipttracker.remote.ServiceBuilder
import androidx.recyclerview.widget.LinearLayoutManager


import com.receipttracker.model.ReceiptCategories
import com.receipttracker.model.ReceiptOverview
import com.receipttracker.model.SavedReceipt

import com.receipttracker.model.receiptRepo
import com.receipttracker.remote.ServiceBuilder.Companion.create
import com.receipttracker.repository.SavedReceiptsDBERepository

import kotlinx.android.synthetic.main.activity_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.StringBuilder

import java.lang.ref.WeakReference
import retrofit2.http.Body



class ListActivity : AppCompatActivity() {

    companion object{
        val receiptList = mutableListOf<SavedReceipt>()
        const val TAG = "receipt string tag"
        const val NEW_ENTRY_REQUEST = 2
        const val EDIT_ENTRY_REQUEST =1
    }

    lateinit var viewModel: ReceiptViewModel

    val apiBuilder = SavedReceiptsDBERepository(this).apiFactory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)



        listActivity_bottomAppBar_fab.setOnClickListener {
            startActivity(Intent(this, AddReceiptActivity::class.java))
/*
        viewModel = ViewModelProviders.of(this).get(ReceiptViewModel::class.java)


       // apiBuilder.getUserReceiptsByID(1)
        var itemList = listOf<SavedReceipt>(SavedReceipt(0,
            "11/11/1386","MCDS", 1.69f, "ghuighsdk","0","0",0),
            SavedReceipt(0, "11/11/1986", "SHOPPING MALL", 200.00f, "horrible experience", "1", "0", 1)
        )
        recycle.apply {
            layoutManager =  LinearLayoutManager(this@ListActivity)
            adapter = ReceiptRecyclerViewAdapter(itemList)

        }

      listActivity_bottomAppBar_fab.setOnClickListener {
          startActivity(Intent(this, AddReceiptActivity::class.java))

//         val entry = itemList
//
  //        intent.putExtra(SavedReceipt.TAG, entry.size -1)
//
    //     startActivityForResult(
//
      //        intent,
//
        //      NEW_ENTRY_REQUEST
//
          //)

       //startActivity(intent)

     }

     //   CreateAsyncTask(viewModel).execute()

        listActivity_bottomAppBar.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
*/
        }

        Log.i("onResponse", LoginActivity.token)
        val call:Call<ListReceipts> = ServiceBuilder.create().getUserReceiptsByID(LoginActivity.token, LoginActivity.userId)

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

                rv_receipts.apply {
                    hasFixedSize()
                    layoutManager = LinearLayoutManager(this@ListActivity)
                    adapter = ReceiptRecyclerViewAdapter(receiptList)
                }

            }

        })


    }

    override fun onResume() {

        super.onResume()
        rv_receipts.apply {
            hasFixedSize()
            layoutManager = LinearLayoutManager(this@ListActivity)
            adapter = ReceiptRecyclerViewAdapter(receiptList)
        }
    }

    override fun onPostResume() {

        super.onPostResume()
        rv_receipts.apply {
            hasFixedSize()
            layoutManager = LinearLayoutManager(this@ListActivity)
            adapter = ReceiptRecyclerViewAdapter(receiptList)
        }
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)



        if (resultCode == RESULT_OK) {

            if (requestCode == NEW_ENTRY_REQUEST) {

                if (data != null) {

                    val entry = data.getSerializableExtra(SavedReceipt.TAG) as SavedReceipt

                    //make sure to add the entry



                    CreateAsynkTask(viewModel).execute(entry)

                    //    repo.createEntry(entry)

                }

            } else if (requestCode == EDIT_ENTRY_REQUEST) {

                if (data != null) {

                    val entry = data.getSerializableExtra(SavedReceipt.TAG) as SavedReceipt

                    //  entryList[entry.id] = entry

               //     UpdateTssk(viewModel).execute(entry)

                    //repo.updateEntry(entry)



                }

            }

        }

    }
    class CreateAsynkTask(viewModel: ReceiptViewModel): AsyncTask<SavedReceipt, Void, Unit>(){



        private val viewModel = WeakReference(viewModel)

        override fun doInBackground(vararg entries: SavedReceipt?) {

            if (entries.isNotEmpty()) {

                entries[0]?.let {

                    viewModel.get()?.receipts

                }

            }

        }

    }




}