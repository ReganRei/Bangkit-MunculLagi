package com.rajatawar.myapplication.ui.main.add

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rajatawar.myapplication.R

class Add2Fragment : Fragment() {

    companion object {
        fun newInstance() = Add2Fragment()
    }

    private lateinit var viewModel: Add2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add2, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(Add2ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}