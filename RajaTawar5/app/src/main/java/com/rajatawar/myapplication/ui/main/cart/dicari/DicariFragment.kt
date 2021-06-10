package com.rajatawar.myapplication.ui.main.cart.dicari

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.rajatawar.myapplication.R
import com.rajatawar.myapplication.data.source.local.entity.ItemCardEntity
import com.rajatawar.myapplication.databinding.DicariFragmentBinding
import com.rajatawar.myapplication.ui.main.MainViewModel
import com.rajatawar.myapplication.ui.main.cart.penawar.PenawarFragment

class DicariFragment : Fragment() {

    private var _binding: DicariFragmentBinding? = null
    private lateinit var adapter: DicariAdapter
    private lateinit var viewModel: MainViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        _binding = DicariFragmentBinding.inflate(inflater, container, false)

        adapter = DicariAdapter()
        adapter.setOnItemClickCallback(object : DicariAdapter.OnItemClickCallback {
            override fun onItemClicked(itemCardEntity: ItemCardEntity) {
                viewModel.setSelectedItem(itemCardEntity)
                addFragment(PenawarFragment())
            }
        })
        viewModel.getListItemDitawarin().observe(viewLifecycleOwner, {
            adapter.setData(it)
        })
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    private fun addFragment(frg: Fragment) {
        fragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_cart_holder, frg)
            ?.commit()
    }

}