package com.example.dagger2.screen

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.dagger2.R
import com.example.dagger2.data.source.model.User
import com.example.dagger2.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainActivityViewModel::class.java)
        binding.viewModel = viewModel
        val adapter = UserAdapter()
        viewModel.setAdapter(adapter)
        viewModel.getListUser()

        user.name = "List User Github"
        textViewUserName.text = user.name
    }
}
