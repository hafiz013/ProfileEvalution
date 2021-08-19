package com.user.profileevalution.api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ClientInterface {
    @GET("viewed/1.json")
    fun getMostView(@Query("api-key") key:String): Call<ResponseBody>

    @GET("shared/1.json")
    fun getMostShared(@Query("api-key") key:String): Call<ResponseBody>

    @GET("emailed/1.json")
    fun getMostEmailed(@Query("api-key") key:String): Call<ResponseBody>

    @GET("articlesearch.json")
    fun getSearchArticle(@Query("q") searchKey:String, @Query("api-key") key:String): Call<ResponseBody>
}