package com.example.aston_intensiv_4.ui.part1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aston_intensiv_4.R
import com.example.aston_intensiv_4.databinding.FragmentCBinding
import com.example.aston_intensiv_4.utils.setFragment
import com.example.aston_intensiv_4.ui.base.BaseFragment

const val FRAGMENT_C_NAME = "FRAGMENT_C"
const val BUNDLE_KEY_MESSAGE = "BUNDLE_KEY_MESSAGE"

class FragmentC : BaseFragment<FragmentCBinding>(
    R.layout.fragment_c
) {
    override fun createBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentCBinding {
        return FragmentCBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = requireArguments()

        binding.apply {

            tvMessageFromB.text = args.getString(BUNDLE_KEY_MESSAGE) ?: ""

            btnNavToD.setOnClickListener {
                parentFragmentManager.setFragment(
                    R.id.mainFragmentContainer,
                    FragmentD(),
                    FRAGMENT_D_NAME
                )
            }

            btnNavToA.setOnClickListener {
                parentFragmentManager.popBackStack(FRAGMENT_A_NAME, 0)
            }
        }
    }

    companion object {
        fun newInstance(bundle: Bundle = Bundle()): FragmentC {
            return FragmentC().apply {
                arguments = bundle
            }
        }
    }
}