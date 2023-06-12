package com.example.retrofit01.networking

import com.example.retrofit01.model.MarvelData
import com.example.retrofit01.model.reqres.UserData
import com.example.retrofit01.model.reqresuser.UserCreator
import com.example.retrofit01.model.reqresuser.UserRes
import com.example.retrofit01.model.single.SingleUser
import com.example.retrofit01.model.updates.UserUpdate
import io.reactivex.rxjava3.core.Observable
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("demos/marvel/")
    fun getMarvels(): Call<List<MarvelData>>

    @GET("api/users")
    fun getUsers(@Query("page") page: Int): Call<UserData>

    @GET("api/users/{id}")
    fun getSingleUser(@Path("id") id: Int): Observable<SingleUser> // Call<SingleUser>

    @POST("api/users")
    fun createUser(@Body userCreator: UserCreator): Call<UserRes>

    @PUT("api/users/{id}")
    fun updateUser(@Path("id") id: Int, @Body reqUserCreator: UserCreator): Call<UserUpdate>

    @DELETE("api/users/{id}")
    fun deleteUser(@Path("id") id: Int): Call<ResponseBody>

}