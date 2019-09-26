package com.receipttracker.ui

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
import retrofit2.http.Body
import java.lang.ref.WeakReference

class ListActivity : AppCompatActivity(), Callback<SavedReceipt> {
    override fun onFailure(call: Call<SavedReceipt>, t: Throwable) {

    }

    override fun onResponse(call: Call<SavedReceipt>, response: Response<SavedReceipt>) {
    }

    lateinit var viewModel: ReceiptViewModel

    val apiBuilder = SavedReceiptsDBERepository(this).apiFactory()





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

       // apiBuilder.getUserReceiptsByID(1)
        var itemList = listOf<SavedReceipt>(SavedReceipt(0,
            11,"MCDS", 1.69f, "ghuighsdk",0), SavedReceipt(0, 11/11/1986, "SHOPPING MALL", 200.00f, "horrible experience", 1))
        recycle.apply {
            layoutManager =  LinearLayoutManager(this@ListActivity)
            adapter = ReceiptRecyclerViewAdapter(itemList)
        }


    }

 //  private fun getReceiptByBusiness(receiptName: String) {
 //      viewModel.receipts

 //  }

    class CreateAsyncTask(viewModel: ReceiptViewModel) : AsyncTask<SavedReceipt, Void, Unit>() {
        private val viewModel = WeakReference(viewModel)
        override fun doInBackground(vararg p0: SavedReceipt?) {
            if (p0.isNotEmpty()) {
                p0[0]?.let {
                    viewModel.get()?.receipts
                }

            }

        }
    }
}