package com.rajatawar.myapplication.ui.main.cart.dicari

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rajatawar.myapplication.data.source.local.entity.ItemCardEntity
import com.rajatawar.myapplication.databinding.ItemCardCartDicariBinding
import com.rajatawar.myapplication.databinding.ItemCardCartMencariBinding
import com.rajatawar.myapplication.ui.main.cart.mencari.MencariAdapter

class DicariAdapter : RecyclerView.Adapter<DicariAdapter.ViewHolder>() {
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
    ): DicariAdapter.ViewHolder {
        val view = ItemCardCartDicariBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    inner class ViewHolder(private val binding: ItemCardCartDicariBinding) :
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
                textView3.text = data.orang_unit.toString()

            }
        }
    }

    override fun onBindViewHolder(holder: DicariAdapter.ViewHolder, position: Int) {
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