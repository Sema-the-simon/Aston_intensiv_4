package com.example.aston_intensiv_4.ui.part2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aston_intensiv_4.R
import com.example.aston_intensiv_4.databinding.FragmentEditUserInfoBinding
import com.example.aston_intensiv_4.model.User
import com.example.aston_intensiv_4.ui.base.BaseFragment
import com.example.aston_intensiv_4.ui.part1.FragmentC

const val EDIT_USER_INFO_FRAGMENT_NAME = "EDIT_USER_INFO_FRAGMENT"
const val BUNDLE_KEY_ID = "BUNDLE_KEY_ID"
const val BUNDLE_KEY_NAME = "BUNDLE_KEY_NAME"
const val BUNDLE_KEY_SURNAME = "BUNDLE_KEY_SURNAME"
const val BUNDLE_KEY_PHONE = "BUNDLE_KEY_PHONE"
const val BUNDLE_KEY_URI = "BUNDLE_KEY_URI"

class EditUserInfoFragment : BaseFragment<FragmentEditUserInfoBinding>(
    R.layout.fragment_edit_user_info
) {

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentEditUserInfoBinding {
        return FragmentEditUserInfoBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = requireArguments()
        val name = args.getString(BUNDLE_KEY_NAME) ?: ""
        val surname = args.getString(BUNDLE_KEY_SURNAME) ?: ""
        val phone = args.getString(BUNDLE_KEY_PHONE) ?: ""
        val uri = args.getString(BUNDLE_KEY_URI) ?: ""

        binding.apply {
            etUserName.setText(name)
            etUserSurname.setText(surname)
            etUserPhoneNumber.setText(phone)
            etUserImgUri.setText(uri)
        }
    }

    companion object {
        fun newInstance(user: User): FragmentC {
            return FragmentC().apply {
                arguments = Bundle().apply {
                    putString(BUNDLE_KEY_NAME, user.name)
                    putString(BUNDLE_KEY_SURNAME, user.surname)
                    putString(BUNDLE_KEY_PHONE, user.phoneNumber)
                    putString(BUNDLE_KEY_URI, user.imgUri)
                }
            }
        }
    }
}