package com.example.aston_intensiv_4.ui.part2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aston_intensiv_4.R
import com.example.aston_intensiv_4.adapter.UsersAdapter
import com.example.aston_intensiv_4.databinding.FragmentUsersListBinding
import com.example.aston_intensiv_4.ui.SHOW_NAV_BUTTONS_KEY
import com.example.aston_intensiv_4.ui.base.BaseFragment
import com.example.aston_intensiv_4.utils.getUsers
import com.example.aston_intensiv_4.utils.setOnBackPressedCallback

const val USER_LIST_FRAGMENT_NAME = "USER_LIST_FRAGMENT"

class UserListFragment : BaseFragment<FragmentUsersListBinding>(
    R.layout.fragment_users_list
) {
    private val adapter = UsersAdapter() { model ->

    }

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentUsersListBinding {
        return FragmentUsersListBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycler.adapter = adapter
        adapter.submitList(getUsers())

        setOnBackPressedCallback(viewLifecycleOwner) {
            parentFragmentManager.apply {
                setFragmentResult(
                    SHOW_NAV_BUTTONS_KEY, Bundle()
                )
                popBackStack()
            }
        }
    }
}