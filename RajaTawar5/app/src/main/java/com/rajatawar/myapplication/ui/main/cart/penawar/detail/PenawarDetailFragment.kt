package com.rajatawar.myapplication.ui.main.cart.penawar.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rajatawar.myapplication.R
import com.rajatawar.myapplication.databinding.FragmentPenawarDetailBinding
import com.rajatawar.myapplication.databinding.MencariFragmentBinding
import com.rajatawar.myapplication.ui.main.MainViewModel
import com.rajatawar.myapplication.ui.main.cart.mencari.MencariAdapter
import com.rajatawar.myapplication.ui.main.cart.penawar.PenawarAdapter
import com.rajatawar.myapplication.ui.main.home.HomeFragment

class PenawarDetailFragment : Fragment() {

    private var _binding: FragmentPenawarDetailBinding? = null
    private lateinit var viewModel: MainViewModel
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        _binding = FragmentPenawarDetailBinding.inflate(inflater, container, false)

/*
        viewModel.getPenawarDetail()
*/
        binding.button4.setOnClickListener {
/*
            viewModel.updateStatus()
*/
            addFragment(HomeFragment())
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
    private fun addFragment(frg: Fragment) {
        fragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_main, frg)
            ?.commit()
    }
}