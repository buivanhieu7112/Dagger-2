package com.example.dagger2.data.source.model

import com.google.gson.annotations.SerializedName
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class User @Inject constructor() {
    @SerializedName("login")
    var name: String? = null
}
