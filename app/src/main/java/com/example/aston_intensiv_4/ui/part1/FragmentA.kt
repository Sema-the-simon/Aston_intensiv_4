package com.example.aston_intensiv_4.ui.part1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aston_intensiv_4.R
import com.example.aston_intensiv_4.databinding.FragmentABinding
import com.example.aston_intensiv_4.ui.SHOW_NAV_BUTTONS_KEY
import com.example.aston_intensiv_4.ui.base.BaseFragment
import com.example.aston_intensiv_4.utils.setFragment
import com.example.aston_intensiv_4.utils.setOnBackPressedCallback

const val FRAGMENT_A_NAME = "FRAGMENT_A"

class FragmentA : BaseFragment<FragmentABinding>(
    R.layout.fragment_a
) {
    override fun createBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentABinding {
        return FragmentABinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNavToBFragment.setOnClickListener {
            parentFragmentManager.setFragment(
                R.id.mainFragmentContainer,
                FragmentB(),
                FRAGMENT_B_NAME
            )
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