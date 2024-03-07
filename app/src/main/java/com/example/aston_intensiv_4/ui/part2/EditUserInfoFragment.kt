package com.example.aston_intensiv_4.ui.part2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import coil.load
import com.example.aston_intensiv_4.R
import com.example.aston_intensiv_4.databinding.FragmentEditUserInfoBinding
import com.example.aston_intensiv_4.model.User
import com.example.aston_intensiv_4.ui.base.BaseFragment
import com.example.aston_intensiv_4.utils.getSerializableCompat

const val EDIT_USER_INFO_FRAGMENT_NAME = "EDIT_USER_INFO_FRAGMENT"
const val EDIT_USER_RESULT_KEY = "EDIT_USER_RESULT_KEY"
const val BUNDLE_KEY = "BUNDLE_KEY"


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

        val user = requireArguments().getSerializableCompat(BUNDLE_KEY, User::class.java)
        if (user != null) {
            setupFields(user)
        }
        setListeners(user)
    }

    private fun setupFields(user: User) {
        binding.apply {
            etUserName.setText(user.name)
            etUserSurname.setText(user.surname)
            etUserPhoneNumber.setText(user.phoneNumber)
            etUserImgUri.setText(user.imgUri)
            ivAvatar.load(user.imgUri)
        }
    }

    private fun setListeners(user: User?) {
        binding.apply {

            etUserImgUri.addTextChangedListener { text ->
                binding.ivAvatar.load(text.toString())
            }

            btnSave.setOnClickListener {
                parentFragmentManager.apply {
                    setFragmentResult(
                        EDIT_USER_RESULT_KEY,
                        createUserBundle(user)
                    )
                    popBackStack()
                }
            }

            btnCancel.setOnClickListener {
                parentFragmentManager.popBackStack()
            }
        }
    }

    private fun createUserBundle(user: User?): Bundle {
        val bundle = Bundle()
        if (user != null) {
            bundle.putSerializable(
                BUNDLE_KEY,
                user.copy(
                    name = binding.etUserName.text.toString(),
                    surname = binding.etUserSurname.text.toString(),
                    phoneNumber = binding.etUserPhoneNumber.text.toString(),
                    imgUri = binding.etUserImgUri.text.toString(),
                )
            )
        }
        return bundle
    }

    companion object {
        fun newInstance(user: User): EditUserInfoFragment {
            return EditUserInfoFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(BUNDLE_KEY, user)
                }
            }
        }
    }
}