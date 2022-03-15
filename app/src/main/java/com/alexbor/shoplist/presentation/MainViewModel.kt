package com.alexbor.shoplist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alexbor.shoplist.data.ShopListRepositoryImpl
import com.alexbor.shoplist.domain.DeleteShopItemUseCase
import com.alexbor.shoplist.domain.EditShopItemUseCase
import com.alexbor.shoplist.domain.GetShopListUseCase
import com.alexbor.shoplist.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()



    fun deleteShopItem(shopItem: ShopItem){
        deleteShopItemUseCase.deleteShopItem(shopItem)

    }

    fun changeEnableState(shopItem: ShopItem){
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopList(newItem)

    }



}