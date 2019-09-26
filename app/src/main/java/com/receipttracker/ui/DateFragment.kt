package com.receipttracker.ui

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.receipttracker.R
import kotlinx.android.synthetic.main.activity_add_receipt.*
import kotlinx.android.synthetic.main.activity_add_receipt.view.*
import java.util.*

class DateFragment:DialogFragment(), DatePickerDialog.OnDateSetListener{

    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {
        val editable = SpannableStringBuilder("$year-$month-$day")
        activity?.text_purchase_date_add?.editText?.text = editable
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        return DatePickerDialog(context!!, this, year, month, day)
    }

    /*
    //When inside a fragment, must create a root to reference the activity that you want to edit.
    private var root: View ?= null //creates a global variable that will hold layout
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.activity_add_receipt, container, false)
        return root
    }
     */
}