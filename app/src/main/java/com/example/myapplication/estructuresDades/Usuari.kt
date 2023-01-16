package com.example.myapplication.estructuresDades

import com.google.gson.annotations.SerializedName

data class Usuari( @SerializedName("image") val image:String, @SerializedName("name")val nom:String,
                   @SerializedName("email") val cognom:String, @SerializedName("role")val role:String)
