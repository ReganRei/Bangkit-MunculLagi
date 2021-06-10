package com.rajatawar.myapplication.ui.main.cart.penawar

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rajatawar.myapplication.MainActivity
import com.rajatawar.myapplication.R
import com.rajatawar.myapplication.data.source.local.entity.ItemCardEntity
import com.rajatawar.myapplication.databinding.ActivityMain2Binding
import com.rajatawar.myapplication.databinding.FragmentPenawarDetailBinding
import com.rajatawar.myapplication.databinding.PenawarFragmentBinding
import com.rajatawar.myapplication.ui.main.MainViewModel
import com.rajatawar.myapplication.ui.main.cart.penawar.detail.PenawarDetailFragment
import com.rajatawar.myapplication.ui.main.home.HomeFragment

class PenawarFragment : Fragment() {

    companion object {
        fun newInstance() = PenawarFragment()
    }
    private lateinit var adapter : PenawarAdapter
    private var _binding: PenawarFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        _binding = PenawarFragmentBinding.inflate(inflater, container, false)

        adapter = PenawarAdapter()
        adapter.setOnItemClickCallback(object : PenawarAdapter.OnItemClickCallback{
            override fun onItemClicked(itemCardEntity: ItemCardEntity) {
viewModel.setSelectedItem(itemCardEntity)
                addFragment(PenawarDetailFragment())
            }

        })
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }
    private fun addFragment(frg: Fragment){
        fragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_cart_holder, frg)
            ?.commit()
    }
}