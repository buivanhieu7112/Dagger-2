package com.example.dagger2.screen

import androidx.lifecycle.MutableLiveData
import com.example.dagger2.base.BaseViewModel
import com.example.dagger2.data.source.model.User

class UserAdapterViewModel : BaseViewModel() {
    private var user: MutableLiveData<User> = MutableLiveData()

    fun setUser(user: User) {
        this.user.value = user
    }

    fun getUser() = user.value
}
