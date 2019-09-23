package com.receipttracker

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.receipttracker.ViewModel.ReceiptViewModel
import com.receipttracker.model.ReceiptOverview
import com.receipttracker.model.SavedReceipt
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.ref.WeakReference

class ListActivity : AppCompatActivity(), Callback<ReceiptOverview> {
    override fun onFailure(call: Call<ReceiptOverview>, t: Throwable) {

    }

    override fun onResponse(call: Call<ReceiptOverview>, response: Response<ReceiptOverview>) {
    }

    lateinit var viewModel: ReceiptViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)


    }

    private fun getReceiptByBusiness(receiptName: String) {
        viewModel.receipts

    }

    class CreateAsyncTask(viewModel: ReceiptViewModel) : AsyncTask<SavedReceipt, Void, Unit>() {
        private val viewModel = WeakReference(viewModel)
        override fun doInBackground(vararg p0: SavedReceipt?) {
            if (p0.isNotEmpty()) {
                p0[0]?.let {
                    viewModel.get()?.createReceipt(it)
                }

            }

        }
    }
}