package com.example.storagetask

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.storagetask.databinding.ItemLayoutBinding

class ItemAdapter(val items: List<Item>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: Item){
            binding.listItem = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val listItemBinding = ItemLayoutBinding.inflate(inflater, parent, false)
        return ItemViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}