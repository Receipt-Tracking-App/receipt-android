package com.receipttracker.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isGone
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.receipttracker.R
import com.receipttracker.model.SavedReceipt
import kotlinx.android.synthetic.main.recycler_item_receipt.view.*

class ReceiptRecyclerViewAdapter(private var savedReceiptList: List<SavedReceipt>): RecyclerView.Adapter<ReceiptRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val priceTextView = view.recyclerItemReceipt_priceTV as TextView
        val dateTextView = view.recyclerItemReceipt_dateTV as TextView
        val businessNameTextView = view.recyclerItemReceipt_businessTV as TextView
        val locationTextView = view.recyclerItemReceipt_locationTV as TextView
        val expandAndCollapseBttn = view.recyclerItemReceipt_expandAndCollapseBttn as ImageButton

        //Expandable stuff
        val expandableLinearLayout = view.recyclerItemReceipt_expandableCL as ConstraintLayout
        val showReceiptPictureBttn = view.recyclerItemReceipt_expandedShowReceiptBttn as MaterialButton
        val notesTextView = view.recyclerItemReceipt_notesTV as TextView

        fun expandAndCollapseBttnOnClick() {

            when(expandableLinearLayout.isGone) {
                true -> {
                    expandableLinearLayout.visibility = View.VISIBLE
                }

                else ->  {
                    expandableLinearLayout.visibility = View.GONE
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewGroup = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_receipt, parent, false)
        val holder = ViewHolder(viewGroup)
        return holder
    }

    override fun getItemCount(): Int {
        return savedReceiptList.size
    }

    override fun onBindViewHolder(holder: ReceiptRecyclerViewAdapter.ViewHolder, position: Int) {

        holder.notesTextView.text = savedReceiptList[position].notes
        holder.priceTextView.text = savedReceiptList[position].price.toString()
        holder.dateTextView.text = savedReceiptList[position].date
        holder.locationTextView.text = savedReceiptList[position].location
        holder.businessNameTextView.text = savedReceiptList[position].merchant
        holder.expandAndCollapseBttn.setOnClickListener {
            holder.expandAndCollapseBttnOnClick()
        }
    }

}