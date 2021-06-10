package com.rajatawar.myapplication.ui.main.input

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.rajatawar.myapplication.R
import com.rajatawar.myapplication.data.source.local.entity.ItemCardDetailEntity
import com.rajatawar.myapplication.data.source.local.entity.ItemCardEntity
import com.rajatawar.myapplication.databinding.InputHargaFragmentBinding
import com.rajatawar.myapplication.ui.main.MainViewModel
import com.rajatawar.myapplication.ui.main.cart.CartFragment

class InputHargaFragment : Fragment() {

    companion object {
        fun newInstance() = InputHargaFragment()
    }

    private var _binding: InputHargaFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this).get(MainViewModel::class.java)

        _binding = InputHargaFragmentBinding.inflate(inflater, container, false)
        viewModel.getDetailItem().observe(viewLifecycleOwner, {
            populateItem(it)
        })
        binding.btnDeal.setOnClickListener {
            viewModel.setHargaTawar(binding.edtPricebid.text.toString())
            addFragment(CartFragment())
        }
        binding.button.setOnClickListener {
            chatWa(viewModel.getPhoneNumber(), binding.edtPricebid.text.toString())
        }

        val root: View = binding.root
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    private fun populateItem(entity: ItemCardEntity) {
        context?.let { Glide.with(it).load(entity.orang_gambar).into(binding.imageView5) }
        binding.tvItemDetail.text = entity.judul
        binding.apply {
            textView6.text = entity.orang_request
            tvPriceHighBid.text = entity.high.toString()
            tvPriceLowBid.text = entity.low.toString()
        }
    }

    private fun chatWa(num: String, price: String) {
        val text = "Halo... saya ingin menawarkan jasa saya seharga " + price
        if (isAppInstalled("com.whatsapp")) {
            val callIntent: Intent =
                Uri.parse("http://api.whatsapp.com/send?phone=" + num + "&text=" + text).let {
                    Intent(Intent.ACTION_VIEW, it)
                }
            startActivity(callIntent)
        }
    }

    private fun isAppInstalled(s: String): Boolean {
        val packageManager = activity?.packageManager
        try {
            if (packageManager != null) {
                packageManager.getPackageInfo(s, PackageManager.GET_ACTIVITIES)
            }
            return true
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
            return false
        }
    }
    private fun addFragment(frg: Fragment){
        fragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_main, frg)
            ?.commit()
    }
}