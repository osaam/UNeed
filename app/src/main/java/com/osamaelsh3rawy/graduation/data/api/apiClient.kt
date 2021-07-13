package com.osamaelsh3rawy.graduation.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object apiClient   {

        private val Base_Url = "http://abdelrhmanelokbe-001-site1.etempurl.com/Api/"
        val apiServies: ApiServies = getRetrofit()

        private fun getRetrofit(): ApiServies {
            return Retrofit.Builder().baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiServies::class.java)
        }
}