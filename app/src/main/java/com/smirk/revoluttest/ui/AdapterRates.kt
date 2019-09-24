package com.smirk.revoluttest.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.smirk.revoluttest.R
import com.smirk.revoluttest.model.CRate
import kotlinx.android.synthetic.main.inflate_rate.view.*

/**
 * Created by Tony Augustine on 12,September,2019
 * tonyaugustine47@gmail.com
 */
class AdapterRates : RecyclerView.Adapter<AdapterRates.RateViewHolder>() {

    private val rates  = ArrayList<CRate>()

    fun setData(newRates : ArrayList<CRate>) {

        val diffCallback = RatingDiffCallback(rates, newRates)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        rates.clear()
        rates.addAll(newRates)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RateViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.inflate_rate, parent, false
        )
        return RateViewHolder(view)
    }

    override fun getItemCount(): Int {
        return rates.size
    }

    override fun onBindViewHolder(holder: RateViewHolder, position: Int) {
        holder.rateTitle.text = rates[position].currency
        holder.rateEdText.setText(rates[position].value)

        holder.itemView.setOnClickListener {

        }
    }


    class RateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.image
        val rateTitle = itemView.rateTitle
        val rateCountryTitle = itemView.rateCountry
        val rateEdText = itemView.rateEd
    }

    class RatingDiffCallback(private val oldList : ArrayList<CRate>, private val newList : ArrayList<CRate>) :
        DiffUtil.Callback() {
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].value === newList[newItemPosition].value
        }

        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return true
        }

    }
}