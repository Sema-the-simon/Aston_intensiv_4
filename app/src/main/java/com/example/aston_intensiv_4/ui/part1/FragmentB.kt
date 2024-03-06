package com.example.aston_intensiv_4.ui.part1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.aston_intensiv_4.R
import com.example.aston_intensiv_4.databinding.FragmentBBinding
import com.example.aston_intensiv_4.setFragment
import com.example.aston_intensiv_4.ui.base.BaseFragment

const val FRAGMENT_B_NAME = "FRAGMENT_B"

class FragmentB : BaseFragment<FragmentBBinding>(
    R.layout.fragment_b
) {
    override fun createBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentBBinding {
        return FragmentBBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNavToC.setOnClickListener {
            parentFragmentManager.setFragment(
                R.id.mainFragmentContainer,
                FragmentC.newInstance(bundleOf(BUNDLE_KEY_MESSAGE to getString(R.string.msg_from_B_to_C))),
                FRAGMENT_C_NAME
            )
        }

        binding.btnNavBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }
}