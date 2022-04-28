package com.example.kamusindonesia_jepang.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kamusindonesia_jepang.ItemCallback
import com.example.kamusindonesia_jepang.data.HiraganaEntity
import com.example.kamusindonesia_jepang.databinding.ItemRowBinding

class HiraganaAdapter(private val callback: ItemCallback) : RecyclerView.Adapter<HiraganaAdapter.ListViewHolder>() {

    private val listData = ArrayList<HiraganaEntity>()

    fun setData(data: List<HiraganaEntity>?) {
        if (data.isNullOrEmpty()) return
        listData.clear()
        listData.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemRowBinding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(itemRowBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size

    inner class ListViewHolder(private val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: HiraganaEntity){
            with(binding){
                Glide.with(itemView.context)
                    .load(data.imgPoster)
                    .into(imgPoster)

                imgKeterangan.text = data.description
                cvItemRow.setOnClickListener {
                    callback.onItemClicked(data)
                }
            }
        }

    }
}