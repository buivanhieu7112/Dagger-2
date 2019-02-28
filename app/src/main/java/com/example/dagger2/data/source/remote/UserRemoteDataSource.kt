package com.example.dagger2.data.source.remote

import com.example.dagger2.data.source.UserDataSource
import com.example.dagger2.data.source.model.User
import io.reactivex.Flowable
import retrofit2.Retrofit
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(retrofit: Retrofit) : UserDataSource.Remote {
    private var apiService: ApiService = retrofit.create(ApiService::class.java)

    override fun getListUser(): Flowable<MutableList<User>> {
        return apiService.getListUser()
    }
}
