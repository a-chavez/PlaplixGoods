package cl.nodalnet.plaplixgoods.models.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import cl.nodalnet.plaplixgoods.models.MyRepository
import cl.nodalnet.plaplixgoods.models.room.ProductsDB
import cl.nodalnet.plaplixgoods.models.room.ProductsItem

class MyViewModel(application: Application):AndroidViewModel(application) {
    private val mMyRepository : MyRepository
    val mAllProducts : LiveData<List<ProductsItem>>

    init {
        val mProductsDAO = ProductsDB.getDataBase(application).getMasterDAO()
        mMyRepository = MyRepository(mProductsDAO)
        mAllProducts = mMyRepository.mLiveData
        mMyRepository.getDataFromServer()
    }

    fun exposeLiveDataFromServer():LiveData<List<ProductsItem>>{
        return mMyRepository.mLiveData
    }
}