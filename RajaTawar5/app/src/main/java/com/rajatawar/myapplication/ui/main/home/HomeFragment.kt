package com.rajatawar.myapplication.ui.main.home

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.rajatawar.myapplication.R
import com.rajatawar.myapplication.data.source.local.entity.ItemCardEntity
import com.rajatawar.myapplication.databinding.FragmentHomeBinding
import com.rajatawar.myapplication.ui.main.ItemCardAdapter
import com.rajatawar.myapplication.ui.main.MainViewModel
import com.rajatawar.myapplication.ui.main.detail.DetailFragment
import com.rajatawar.myapplication.ui.main.search.SearchFragment
import com.rajatawar.myapplication.utils.BasicFragment

class HomeFragment : BasicFragment() {
    private lateinit var auth: FirebaseAuth
    private lateinit var mainViewModel: MainViewModel
    private var _binding: FragmentHomeBinding? = null
    private lateinit var adapter: ItemCardAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainViewModel =
            ViewModelProvider(this).get(MainViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.edtQueryHome.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                searchItem()
                addFragment(SearchFragment())

                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }
        adapter = ItemCardAdapter()

        mainViewModel.getListItemCard().observe(viewLifecycleOwner,{
            adapter.setData(it)
        })

        adapter.setOnItemClickCallback(object : ItemCardAdapter.OnItemClickCallback{
            override fun onItemClicked(itemCardEntity: ItemCardEntity) {
                mainViewModel.setSelectedItem(itemCardEntity)
                addFragment(DetailFragment())
            }
        })
        binding.btnViewAll.setOnClickListener {
            addFragment(SearchFragment())
        }
        //kalau find dengan gambar di klik belum
        //kalau klik gambar promo belum tapi kayaknya gak usah
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth

    }
    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        mainViewModel.setUser(currentUser)
        mainViewModel.setAuth(auth)
        updateUI(currentUser)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun updateUI(currentUser: FirebaseUser?) {
        context?.let {
            Glide.with(it)
                .load(currentUser?.photoUrl)
                .into(binding.circleImageView)
        }
        if (currentUser != null) {
            binding.tvUserName.text = currentUser.displayName
        }
    }

    private fun searchItem(): Boolean {
        val query = binding.edtQueryHome.text.toString()
        return if (query.isEmpty()) {
            false
        } else {
            mainViewModel.setQuery(query)
            true
        }
    }
    private fun addFragment(frg: Fragment){
        fragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_main, frg)
            ?.commit()
    }

}