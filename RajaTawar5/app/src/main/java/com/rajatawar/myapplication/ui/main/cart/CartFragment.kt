package com.rajatawar.myapplication.ui.main.cart

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rajatawar.myapplication.R
import com.rajatawar.myapplication.databinding.FragmentCartBinding
import com.rajatawar.myapplication.ui.main.MainViewModel
import com.rajatawar.myapplication.ui.main.cart.dicari.DicariFragment
import com.rajatawar.myapplication.ui.main.cart.mencari.MencariFragment

class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.button7.setOnClickListener {
            addFragment(DicariFragment())
        }
        binding.button6.setOnClickListener {
            addFragment(MencariFragment())
        }

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        addFragment(MencariFragment())
    }
    private fun addFragment(frg: Fragment){
        fragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_cart_holder, frg)
            ?.commit()
    }
}