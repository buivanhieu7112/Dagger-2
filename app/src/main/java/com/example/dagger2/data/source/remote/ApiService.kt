package com.example.dagger2.data.source.remote

import com.example.dagger2.data.source.model.User
import io.reactivex.Flowable
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getListUser(): Flowable<MutableList<User>>
}
