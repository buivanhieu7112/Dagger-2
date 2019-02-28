package com.example.dagger2.screen

import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.dagger2.R
import com.example.dagger2.data.source.model.User
import com.example.dagger2.databinding.AdapterUserBinding

class UserAdapter : androidx.recyclerview.widget.RecyclerView.Adapter<UserAdapter.Companion.UserViewHolder>() {
    private var users: MutableList<User> = mutableListOf()

    fun updateData(users: MutableList<User>) {
        this.users.addAll(users)
        notifyItemInserted(users.lastIndex - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding: AdapterUserBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.adapter_user, parent, false)
        return UserViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindData(users[position])
    }

    companion object {
        class UserViewHolder(private val binding: AdapterUserBinding) : RecyclerView.ViewHolder(binding.root) {
            init {
                binding.viewModel = UserAdapterViewModel()
            }

            fun bindData(user: User) {
                binding.viewModel!!.setUser(user)
            }
        }
    }
}
