package com.rajatawar.myapplication.ui.main.cart.penawar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rajatawar.myapplication.data.source.local.entity.ItemCardEntity
import com.rajatawar.myapplication.databinding.ItemCardCartPenawarBinding

class PenawarAdapter : RecyclerView.Adapter<PenawarAdapter.ViewHolder>() {
    private var listData = ArrayList<ItemCardEntity>()
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(itemCardEntity: ItemCardEntity)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PenawarAdapter.ViewHolder {
        val view = ItemCardCartPenawarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    inner class ViewHolder(private val binding: ItemCardCartPenawarBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val BASE_IMG = "https://image.tmdb.org/t/p/w500"
        fun bind(data: ItemCardEntity) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(BASE_IMG + data.gambar)
                    .into(imageView)
                tvItemDetail.text = data.judul
                tvLowPrice.text = data.low.toString()
                tvHighPrice.text = data.high.toString()
                tvLocation.text = data.lokasi
                textView6.text = data.unit.toString()
                textView17.text = data.status
                textView14.text = data.tawaran

            }
        }
    }

    override fun onBindViewHolder(holder: PenawarAdapter.ViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    fun setData(list: List<ItemCardEntity>) {
        listData.clear()
        listData.addAll(list)
        notifyDataSetChanged()
    }
}