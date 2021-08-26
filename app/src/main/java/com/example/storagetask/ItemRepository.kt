package com.example.storagetask

import androidx.lifecycle.LiveData

class ItemRepository(private val itemDao: ItemDao) {

    val readAllData: LiveData<List<Item>> = itemDao.readAllData()

    suspend fun addItem(item:Item){
        itemDao.addItem(item)
    }
    fun nukeTable(){
        itemDao.nukeTable()
    }
}