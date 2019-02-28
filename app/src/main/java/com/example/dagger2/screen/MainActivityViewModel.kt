package com.example.dagger2.screen

import android.util.Log
import com.example.dagger2.base.BaseViewModel
import com.example.dagger2.data.source.UserRepository
import com.example.dagger2.data.source.model.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(var userRepository: UserRepository) : BaseViewModel() {
    private lateinit var userAdapter: UserAdapter

    fun setAdapter(userAdapter: UserAdapter){
        this.userAdapter = userAdapter
    }

    fun getAdapter() = userAdapter

    fun getListUser() {
        val disposable: Disposable = userRepository.getListUser()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result -> handleSuccess(result) }, { error -> handleFailure(error) })
        launchDisposable(disposable)
    }

    private fun handleSuccess(result: MutableList<User>) {
        userAdapter.updateData(result)
        Log.d("SUCCESS", "${result.size} ${result[1].name}")
    }

    private fun handleFailure(error: Throwable) {
        Log.e("ERROR", "HandleError: ${error.localizedMessage}")
    }
}
