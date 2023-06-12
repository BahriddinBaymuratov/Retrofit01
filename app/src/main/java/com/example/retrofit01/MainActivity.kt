package com.example.retrofit01

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofit01.networking.ApiClient
import com.example.retrofit01.networking.ApiService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    @SuppressLint("CheckResult")
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

        apiService.getSingleUser(1)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d(TAG, "onCreate: $it ")
            }

//        apiService.createUser(UserCreator("Developer","Jonathan")).enqueue(object :Callback<UserRes>{
//            override fun onResponse(call: Call<UserRes>, response: Response<UserRes>) {
//                if (response.isSuccessful){
//                    Log.d("@@@", "onResponse: ${response.body()}")
//                }
//            }
//
//            override fun onFailure(call: Call<UserRes>, t: Throwable) {}
//        })
        
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