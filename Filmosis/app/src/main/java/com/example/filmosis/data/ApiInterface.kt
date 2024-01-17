package com.example.filmosis.data

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("obtenerUsuarios.php")
    fun getUsuarios(): Call<List<UsuarioItem>>
}