package com.example.githubuser.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubuser.api.RetrofitClient
import com.example.githubuser.data.model.User
import com.example.githubuser.data.model.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    private val listUsers = MutableLiveData<ArrayList<User>>()

    private val searchList = MutableLiveData<ArrayList<UserResponse>>()


    fun setSearchUsers(query: String){
        RetrofitClient.apiServiceInstance
            .getSearchUsers(query)
            .enqueue(object : Callback<UserResponse>{
                override fun onResponse(
                    call: Call<UserResponse>, // Callback -> retrofit2
                    response: Response<UserResponse>
                ) {
                    if (response.isSuccessful){
                        listUsers.postValue(response.body()?.items)
                    }
                }

                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                   Log.d("Failure", t.message!!)
                }
            })
    }

    fun getSearchUsers(): LiveData<ArrayList<User>>{
        return listUsers
    }


    companion object {
        private const val TAG = "MainViewModel"
    }

}