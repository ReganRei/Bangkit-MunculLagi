package com.rajatawar.myapplication.data

import androidx.lifecycle.LiveData
import com.rajatawar.myapplication.data.source.local.entity.ItemCardDetailEntity
import com.rajatawar.myapplication.data.source.local.entity.ItemCardEntity
import com.rajatawar.myapplication.data.source.local.entity.ItemCardHomeEntity
import com.rajatawar.myapplication.data.source.local.entity.ItemCardSearchEntity

interface PilemDataSource {
    fun getListItemCard(): LiveData<List<ItemCardEntity>>
    fun getListItemCardSearch(query:String): LiveData<List<ItemCardEntity>>

}
