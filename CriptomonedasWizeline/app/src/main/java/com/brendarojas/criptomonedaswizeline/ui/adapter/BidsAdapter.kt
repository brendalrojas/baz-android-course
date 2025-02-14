package com.brendarojas.criptomonedaswizeline.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.brendarojas.criptomonedaswizeline.databinding.CryptoBidsItemBinding
import com.brendarojas.criptomonedaswizeline.domain.model.BidsModelDomain

class BidsAdapter() : ListAdapter<BidsModelDomain, BidsAdapter.ViewHolder>(difCallback) {

    companion object {
        var difCallback = object : DiffUtil.ItemCallback<BidsModelDomain>() {
            override fun areItemsTheSame(oldItem: BidsModelDomain, newItem: BidsModelDomain): Boolean =
                oldItem.bookBids == newItem.bookBids
            override fun areContentsTheSame(oldItem: BidsModelDomain, newItem: BidsModelDomain): Boolean =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val bookBinding = CryptoBidsItemBinding.inflate(inflater, viewGroup, false)
        return ViewHolder(bookBinding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.enlazarItem(getItem(position))
    }

    inner class ViewHolder(val binding: CryptoBidsItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun enlazarItem(bidsModel: BidsModelDomain) {
            binding.txtPriceBids.text = "Price = $ ${bidsModel.priceBids}.00"
            binding.txtAmountBids.text = "  ->   Amount = ${bidsModel.amountBids}"
        }
    }
}
