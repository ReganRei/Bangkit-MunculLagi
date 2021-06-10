package com.rajatawar.myapplication.ui.main.profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.rajatawar.myapplication.MainActivity
import com.rajatawar.myapplication.R
import com.rajatawar.myapplication.data.source.local.entity.ItemCardEntity
import com.rajatawar.myapplication.ui.main.MainViewModel

class ProfileFragment : Fragment() {
private lateinit var list : ArrayList<ItemCardEntity>
    companion object {
        fun newInstance() = ProfileFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        list = ArrayList<ItemCardEntity>()
    }
    fun getProduct() {
        val queue: RequestQueue = Volley.newRequestQueue(activity)
        val reques = JsonArrayRequest(
            Request.Method.GET,
            "http://34.101.182.147/produk_bidding_api.php",
            null,
            { response ->
                for (s in 0..response.length() - 1) {
                    val job = response.getJSONObject(s)

                    var gambar: String = job.getInt("gambar").toString()
                    var judul: String = job.getInt("judul_produk").toString()
                    var unit: String= job.getInt("total_dibutuhkan").toString()
                    var lokasi: String? = null
                    var low: String= job.getInt("harga_min").toString()
                    var high: String= job.getInt("harga_max").toString()
                    var deskripsi: String= job.getInt("deskripsi_produk").toString()
                    var jarak: String? = null
                    var orang_request: String= job.getInt("gambar").toString()
                    var orang_gambar: String= job.getInt("gambar").toString()
                    var tawaran: String= job.getInt("gambar").toString()
                    var phone: String= job.getInt("gambar").toString()
                    var orang_unit: String= job.getInt("gambar").toString()
                    var status: String= job.getInt("gambar").toString()


                    list.add(ItemCardEntity(gambar, judul, unit, lokasi.toString(), low, high, deskripsi,
                        jarak.toString(), orang_request, orang_gambar, tawaran, phone, orang_unit,status))
                    val adapterku = ProductAdapter(requireContext(), list)
                    recycler.layoutManager = LinearLayoutManager(requireContext())
                    recycler.adapter = adapterku
                }
            },
            { error ->
                Log.d("showError", error.toString())
            })
        queue.add(reques)
    }
}