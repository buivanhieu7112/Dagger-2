package com.example.dagger2.data.source

import com.example.dagger2.data.source.model.User
import com.example.dagger2.data.source.remote.UserRemoteDataSource
import io.reactivex.Flowable
import javax.inject.Inject

class UserRepository @Inject constructor(var remote: UserRemoteDataSource) : UserDataSource.Remote {
    override fun getListUser(): Flowable<MutableList<User>> {
        return remote.getListUser()
    }
}
