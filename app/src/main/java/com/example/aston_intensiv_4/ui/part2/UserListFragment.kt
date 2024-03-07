package com.example.aston_intensiv_4.ui.part2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.aston_intensiv_4.R
import com.example.aston_intensiv_4.databinding.FragmentUsersListBinding
import com.example.aston_intensiv_4.model.User
import com.example.aston_intensiv_4.ui.SHOW_NAV_BUTTONS_KEY
import com.example.aston_intensiv_4.ui.base.BaseFragment
import com.example.aston_intensiv_4.ui.part2.adapter.UsersAdapter
import com.example.aston_intensiv_4.utils.getSerializableCompat
import com.example.aston_intensiv_4.utils.setFragment
import com.example.aston_intensiv_4.utils.setOnBackPressedCallback
import kotlinx.coroutines.launch

const val USER_LIST_FRAGMENT_NAME = "USER_LIST_FRAGMENT"

class UserListFragment : BaseFragment<FragmentUsersListBinding>(
    R.layout.fragment_users_list
) {
    private val viewModel: UsersViewModel by viewModels()
    private val adapter = UsersAdapter { model ->
        parentFragmentManager.setFragment(
            R.id.mainFragmentContainer,
            EditUserInfoFragment.newInstance(model),
            EDIT_USER_INFO_FRAGMENT_NAME
        )
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

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { uiState ->
                    adapter.submitList(uiState.usersList)
                }
            }
        }

        parentFragmentManager.setFragmentResultListener(
            EDIT_USER_RESULT_KEY,
            this
        ) { _, bundle ->
            val user = bundle.getSerializableCompat(BUNDLE_KEY, User::class.java)
            if (user != null)
                viewModel.changeUser(user)
        }

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