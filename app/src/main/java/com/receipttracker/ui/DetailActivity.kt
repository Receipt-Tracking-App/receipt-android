package com.receipttracker.ui

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.receipttracker.R
import com.receipttracker.ViewModel.ReceiptViewModel
import com.receipttracker.model.SavedReceipt
import kotlinx.android.synthetic.main.activity_detail.*
import java.lang.ref.WeakReference

class DetailActivity : AppCompatActivity() {

    lateinit var viewModel: ReceiptViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


    button_add_receipts.setOnClickListener {
        val intent = Intent(this, ListActivity::class.java)
        startActivity(intent)
    }




        viewModel = ViewModelProviders.of(this).get(ReceiptViewModel::class.java)
        ReadAllAsyncTask(this).execute()

    }
    fun createTextView(savedReceipt: SavedReceipt): TextView{
        val view = TextView(this)
        view.text = savedReceipt.merchant
        view.tag = savedReceipt.receiptId

        view.setOnLongClickListener {
            DeleteAsyncTask(viewModel).execute(savedReceipt)
            return@setOnLongClickListener true
        }
        return view



    }




    class DeleteAsyncTask(viewModel: ReceiptViewModel): AsyncTask<SavedReceipt, Void, Unit>(){
        private val viewModel = WeakReference(viewModel)
        override fun doInBackground(vararg p0: SavedReceipt?) {
            if (p0.isNotEmpty()){
                p0[0]?.let {
                    viewModel.get()?.receipts
                }
            }
        }

    }
    class UpdateAsynkTask(viewModel: ReceiptViewModel): AsyncTask<SavedReceipt, Void, Unit>(){
        private val viewModel =WeakReference(viewModel)
        override fun doInBackground(vararg p0: SavedReceipt?) {
            if (p0.isNotEmpty()){
                p0[0]?.let {
                    viewModel.get()?.receipts
                }
            }
        }

    }



    private fun updateForEntries(savedReceipt: List<SavedReceipt>){

            receipt_list.removeAllViews()

        savedReceipt.forEach {
            receipt_list.addView(createTextView(it))
        }


    }
    class ReadAllAsyncTask(activity: DetailActivity): AsyncTask<Void, Void, LiveData<List<SavedReceipt>>?>(){

        private val activity = WeakReference(activity)
        override fun doInBackground(vararg p0: Void?): LiveData<List<SavedReceipt>>? {
            return activity.get()?.viewModel?.receipts
        }

        override fun onPostExecute(result: LiveData<List<SavedReceipt>>?) {
            activity.get()?.let {act ->
                result?.let {entries ->
                    entries.observe(act,
                        Observer<List<SavedReceipt>> { t ->
                            t?.let {
                                act.updateForEntries(t)
                            }
                        }

                        )
                }
            }
        }


    }

}
