package cl.nodalnet.plaplixgoods.models.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("products")
    fun getDataFromApi(): Call<ProductsList>
}