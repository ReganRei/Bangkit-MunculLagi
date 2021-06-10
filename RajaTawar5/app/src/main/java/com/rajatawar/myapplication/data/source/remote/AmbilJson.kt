/*
package com.rajatawar.myapplication.data.source.remote

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class AmbilJson {
    fun getProduct() {
        val queue: RequestQueue = Volley.newRequestQueue(activity)
        val reques = JsonArrayRequest(
            Request.Method.GET,
            "http://192.168.43.183/store/apiproduct.php",
            null,
            { response ->
                for (s in 0..response.length() - 1) {
                    val job = response.getJSONObject(s)
                    val id = job.getInt("id")
                    val name = job.getString("name")
                    val harga = job.getInt("harga")
                    val photo = job.getString("photo").replace("localhost", "192.168.43.183")
                    val deskripsi = job.getString("deskripsi")

                    list.add(Product(id, name, harga, deskripsi, photo))
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
}*/
