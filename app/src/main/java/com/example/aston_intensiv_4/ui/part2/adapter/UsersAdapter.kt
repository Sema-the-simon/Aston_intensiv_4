package com.example.aston_intensiv_4.ui.part2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.aston_intensiv_4.R
import com.example.aston_intensiv_4.databinding.UserItemBinding
import com.example.aston_intensiv_4.model.User

class UsersAdapter(
    private val onClickAction: (User) -> Unit
) : ListAdapter<User, UsersAdapter.UserViewHolder>(
    UserDiffUtil
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = UserItemBinding.inflate(inflater, parent, false)
        val holder = UserViewHolder(binding)

        binding.root.setOnClickListener {
            val model = getItem(holder.adapterPosition)
            onClickAction(model)
        }

        return holder
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val model = getItem(position)
        holder.bind(model)
    }

    class UserViewHolder(private val binding: UserItemBinding) : ViewHolder(binding.root) {

        fun bind(user: User) {
            binding.userItemId.text =
                binding.root.context.getString(R.string.user_id, user.id.toString())
            binding.tvUserItemName.text = user.name
            binding.tvUserItemSurname.text = user.surname
            binding.tvUserItemPhoneNumber.text = user.phoneNumber
            binding.imageView.load(user.imgUri)
        }
    }

    object UserDiffUtil : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }
}