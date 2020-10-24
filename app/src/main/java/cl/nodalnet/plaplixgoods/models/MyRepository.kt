package cl.nodalnet.plaplixgoods.models

import android.util.Log
import cl.nodalnet.plaplixgoods.models.retrofit.ProductsList
import cl.nodalnet.plaplixgoods.models.retrofit.RetrofitClient
import cl.nodalnet.plaplixgoods.models.room.ProductsDAO
import cl.nodalnet.plaplixgoods.models.room.ProductsItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyRepository(private val mProductsDAO: ProductsDAO) {
    private val service = RetrofitClient.getRetrofitClient()

    val mLiveData = mProductsDAO.getAllData()
    val mDataProductsItem = mutableListOf<ProductsItem>()

    fun getDataFromServer() {
        Log.d("Arroz", "getDataFromServer")
        val mCall = service.getDataFromApi()
        mCall.enqueue(object : Callback<ProductsList> {
            override fun onResponse(call: Call<ProductsList>, response: Response<ProductsList>) {
                //Log.d("Arroz onResponse", response.code().toString())
                when(response.code()){

                    in 200..299 -> CoroutineScope(Dispatchers.IO).launch{
                        response.body()?.let{
                            //Log.d("Arroz desde API", it.toString())
                            mProductsDAO.insertAllData(it)
                        }

                    }
                    in 300..399 -> Log.d("ERROR 300", response.errorBody().toString())
                }

            }

            override fun onFailure(call: Call<ProductsList>, t: Throwable) {
                Log.e("MyRepository", t.message.toString())
            }

        })
    }

}