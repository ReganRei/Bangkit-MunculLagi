package com.rajatawar.myapplication.ui.main.search

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.rajatawar.myapplication.R
import com.rajatawar.myapplication.data.source.local.entity.ItemCardEntity
import com.rajatawar.myapplication.databinding.FragmentSearchBinding
import com.rajatawar.myapplication.ui.main.MainViewModel
import com.rajatawar.myapplication.ui.main.detail.DetailFragment
import com.rajatawar.myapplication.ui.main.ItemCardAdapter

class SearchFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private var _binding: FragmentSearchBinding? = null
    private lateinit var adapter: ItemCardAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this).get(MainViewModel::class.java)

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root
        viewModel.getListItemCardSearch().observe(viewLifecycleOwner,{
            adapter.setData(it)
        })
        binding.edtQuerySearch.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                viewModel.setQuery(binding.edtQuerySearch.text.toString())

                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }

        adapter.setOnItemClickCallback(object : ItemCardAdapter.OnItemClickCallback {
            override fun onItemClicked(itemCardEntity: ItemCardEntity) {
                viewModel.setSelectedItem(itemCardEntity)
                addFragment(DetailFragment())
            }
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun addFragment(frg: Fragment) {
        fragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_main, frg)
            ?.commit()
    }
}