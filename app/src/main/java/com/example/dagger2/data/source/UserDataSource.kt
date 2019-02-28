package com.example.dagger2.data.source

import com.example.dagger2.data.source.model.User
import io.reactivex.Flowable

interface UserDataSource {
    interface Remote {
        fun getListUser(): Flowable<MutableList<User>>
    }
}
