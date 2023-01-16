package com.example.myapplication.retrofit

import com.example.myapplication.MyDataItem
import com.example.myapplication.estructuresDades.LoginUsuari
import com.example.myapplication.estructuresDades.Usuari
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface APIService {


   //@GET("getAboutTheTeam")

   //fun getAboutTheTeam(): Call<List<MyDataItem>>
   @GET
   suspend fun getUsuaris(@Url url:String): Response<List<Usuari>>
   //it returns response class of usuari in the Usuari data class

   @GET("{ruta}/get.php?lletra=a")
   suspend fun getValues(@Path("ruta")ruta:String, @Query("lletra")lletra:String): Response<List<Usuari>>

   @Headers("Accept: application/json", "Content-Type: application/json")

   @POST("{ruta}/login.php")
   suspend fun postLogin(@Path("ruta")ruta:String, @Body loginUsuari: LoginUsuari):Response<Usuari>

}