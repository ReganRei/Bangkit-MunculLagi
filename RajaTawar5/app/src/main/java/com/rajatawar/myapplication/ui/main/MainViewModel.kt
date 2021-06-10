package com.rajatawar.myapplication.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.rajatawar.myapplication.data.RajaTawarRepository
import com.rajatawar.myapplication.data.source.local.entity.*

class MainViewModel(private val rajaTawarRepository: RajaTawarRepository) : ViewModel() {
    private var query: String? = null
    private lateinit var auth: FirebaseAuth
    private lateinit var user: FirebaseUser
    private lateinit var itemCardEntity: ItemCardEntity


    fun getListItemCard(): LiveData<List<ItemCardEntity>> {
        return rajaTawarRepository.getListItemCard()
    }

    fun setQuery(query: String) {
        this.query = query
    }

    fun setUser(currentUser: FirebaseUser?) {
        if (currentUser != null) {
            this.user = currentUser
        }
    }

    fun setAuth(auth: FirebaseAuth) {
        this.auth = auth
    }

    fun setSelectedItem(itemCardEntity: ItemCardEntity) {
        this.itemCardEntity = itemCardEntity
    }

    fun getSelectedItem(): LiveData<ItemCardEntity> {
        val entity = MutableLiveData<ItemCardEntity>()
        entity.postValue(itemCardEntity)
        return entity
    }

    fun getListItemCardSearch(): LiveData<List<ItemCardEntity>> {
        if (query == null) {
            return getListItemCard()
        } else {
            return rajaTawarRepository.getListItemCardSearch(query!!)
        }
    }

    fun getDetailItem(): LiveData<ItemCardEntity> {
        return rajaTawarRepository.getDetailItemCard()

    }

    fun setHargaTawar(text: String) {
this.itemCardEntity.tawaran =text
    }

    fun getPhoneNumber(): String {
        return this.itemCardEntity.phone
    }

    fun getAuth(): FirebaseAuth {
        return auth
    }

    fun setAddItem1(imgUrl: String, judul: String, deskripsi: String) {
        TODO("Not yet implemented")
    }

    fun getListUserNawar(): LiveData<List<ItemCardEntity>> {
        TODO("Not yet implemented")
    }

}