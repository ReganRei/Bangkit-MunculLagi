package com.rajatawar.myapplication.ui.main.cart.mencari

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rajatawar.myapplication.R
import com.rajatawar.myapplication.data.source.local.entity.ItemCardEntity
import com.rajatawar.myapplication.databinding.FragmentHomeBinding
import com.rajatawar.myapplication.databinding.MencariFragmentBinding
import com.rajatawar.myapplication.ui.main.MainViewModel

class MencariFragment : Fragment() {

    private var _binding: MencariFragmentBinding? = null
    private lateinit var adapter: MencariAdapter
    private lateinit var viewModel: MainViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        _binding = MencariFragmentBinding.inflate(inflater, container, false)
        viewModel.getListMyTawaran().observe(viewLifecycleOwner,{
            adapter.setData(it)
        })
        adapter = MencariAdapter()


        val root: View = binding.root
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
    private fun addFragment(frg: Fragment){
        fragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_cart_holder, frg)
            ?.commit()
    }
}