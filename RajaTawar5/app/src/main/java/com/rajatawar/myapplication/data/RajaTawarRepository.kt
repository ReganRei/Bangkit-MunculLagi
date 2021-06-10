package com.rajatawar.myapplication.data

import androidx.lifecycle.LiveData
import com.rajatawar.myapplication.data.source.RemoteDataSource
import com.rajatawar.myapplication.data.source.local.entity.ItemCardEntity

class RajaTawarRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    PilemDataSource {
    override fun getListItemCard(): LiveData<List<ItemCardEntity>> {
        TODO("Not yet implemented")
    }

    override fun getListItemCardSearch(query: String): LiveData<List<ItemCardEntity>> {
        TODO("Not yet implemented")
    }

}
