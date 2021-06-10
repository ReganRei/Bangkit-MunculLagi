package com.rajatawar.myapplication.ui.main.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.rajatawar.myapplication.R
import com.rajatawar.myapplication.data.source.local.entity.ItemCardEntity
import com.rajatawar.myapplication.databinding.DetailFragmentBinding
import com.rajatawar.myapplication.ui.main.MainViewModel
import com.rajatawar.myapplication.ui.main.input.InputHargaFragment

class DetailFragment : Fragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }

    private var _binding: DetailFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this).get(MainViewModel::class.java)

        _binding = DetailFragmentBinding.inflate(inflater, container, false)
        viewModel.getDetailItem().observe(viewLifecycleOwner, {
            populateItem(it)
        })
        binding.btnDeal.setOnClickListener {
            addFragment(InputHargaFragment())
        }

        val root: View = binding.root
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    private fun populateItem(entity: ItemCardEntity) {
        context?.let { Glide.with(it).load(entity.gambar).into(binding.imageView5) }
        binding.tvItemDetail.text = entity.judul
        binding.apply {
            tvDescriptionDetail.text = entity.deskripsi
            tvLocationBid.text = entity.lokasi
            tvUnitBid.text = entity.unit.toString()
            textView6.text = entity.orang_request
            tvPriceHighBid.text = entity.high.toString()
            tvPriceLowBid.text = entity.low.toString()
        }
    }

    private fun addFragment(frg: Fragment) {
        fragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_main, frg)
            ?.commit()
    }
}