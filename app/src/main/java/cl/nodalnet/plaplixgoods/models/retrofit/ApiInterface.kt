package cl.nodalnet.plaplixgoods.models.retrofit

import cl.nodalnet.plaplixgoods.models.room.DetailsItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("products")
    fun getDataFromApi(): Call<ProductsList>

    @GET("details")
    fun getDataFromOne(): Call<DetailsList>
}