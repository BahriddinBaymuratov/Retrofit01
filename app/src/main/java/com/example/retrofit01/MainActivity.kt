package com.example.retrofit01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.retrofit01.model.MarvelData
import com.example.retrofit01.model.reqres.UserData
import com.example.retrofit01.model.reqresuser.UserCreator
import com.example.retrofit01.model.reqresuser.UserRes
import com.example.retrofit01.model.single.SingleUser
import com.example.retrofit01.networking.ApiClient
import com.example.retrofit01.networking.ApiService
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val okHttpClient = OkHttpClient()
//        val request = Request.Builder().url("https://jsonplaceholder.typicode.com/users/1").build()
//        okHttpClient.newCall(request).enqueue(object : okhttp3.Callback{
//            override fun onFailure(call: okhttp3.Call, e: IOException) {
//
//            }
//
//            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
//                if (response.isSuccessful){
////                    Log.d("@@@", "onResponse: ${response.body?.string()}")
//                }
//            }
//        })


        val apiService = ApiClient.getRetrofit().create(ApiService::class.java)

        apiService.createUser(UserCreator("Developer","Jonathan")).enqueue(object :Callback<UserRes>{
            override fun onResponse(call: Call<UserRes>, response: Response<UserRes>) {
                if (response.isSuccessful){
                    Log.d("@@@", "onResponse: ${response.body()}")
                }
            }

            override fun onFailure(call: Call<UserRes>, t: Throwable) {}
        })
        
//        apiService.getSingleUser(23).enqueue(object : Callback<SingleUser>{
//            override fun onResponse(call: Call<SingleUser>, response: Response<SingleUser>) {
//                if (response.isSuccessful){
//                    Log.d("@@@", "onResponse: Succesfully")
//                }else if (response.code() in 400..499){
//                    Log.d("@@@", "onResponse: client error ")
//                }
//            }
//
//            override fun onFailure(call: Call<SingleUser>, t: Throwable) {
//
//            }
//        })
        

//        apiService.getUsers(1).enqueue(object :Callback<UserData>{
//            override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
//                
//            }
//
//            override fun onFailure(call: Call<UserData>, t: Throwable) {
//                
//            }
//        })

//        apiService.getMarvels().enqueue(object : Callback<List<MarvelData>>{
//            override fun onResponse(
//                call: Call<List<MarvelData>>,
//                response: Response<List<MarvelData>>
//            ) {
//                if (response.isSuccessful && response !=null){
////                    Log.d("@@@", "onResponse: ${response.body()}")
//                }
//            }
//
//            override fun onFailure(call: Call<List<MarvelData>>, t: Throwable) {
//
//            }
//        })

    }
}