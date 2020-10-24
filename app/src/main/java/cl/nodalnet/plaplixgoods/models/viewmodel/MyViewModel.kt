package cl.nodalnet.plaplixgoods.models.viewmodel

import android.app.Application
import android.telecom.Call
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import cl.nodalnet.plaplixgoods.models.MyRepository
import cl.nodalnet.plaplixgoods.models.room.DetailsItem
import cl.nodalnet.plaplixgoods.models.room.ProductsDB
import cl.nodalnet.plaplixgoods.models.room.ProductsItem

class MyViewModel(application: Application):AndroidViewModel(application) {
    private val mMyRepository : MyRepository
    val mAllProducts : LiveData<List<ProductsItem>>
    val mAllDetails : LiveData<List<DetailsItem>>

    init {
        val mProductsDAO = ProductsDB.getDataBase(application).getMasterDAO()
        val mDetailsDAO = ProductsDB.getDataBase(application).getDetailstDAO()
        mMyRepository = MyRepository(mProductsDAO, mDetailsDAO)
        mAllProducts = mMyRepository.mLiveData
        mAllDetails = mMyRepository.mLiveDataDetails
        mMyRepository.getDataFromProducts()
        mMyRepository.getDataFromDetails()
    }
/*
    fun exposeLiveDataFromServer():LiveData<List<ProductsItem>>{
        return mMyRepository.mLiveData
    }

 */
}