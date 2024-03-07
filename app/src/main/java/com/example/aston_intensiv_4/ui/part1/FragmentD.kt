package com.example.aston_intensiv_4.ui.part1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aston_intensiv_4.R
import com.example.aston_intensiv_4.databinding.FragmentDBinding
import com.example.aston_intensiv_4.ui.base.BaseFragment

const val FRAGMENT_D_NAME = "FRAGMENT_D"

class FragmentD : BaseFragment<FragmentDBinding>(
    R.layout.fragment_d
) {
    override fun createBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentDBinding {
        return FragmentDBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNavToB.setOnClickListener {
            parentFragmentManager.popBackStack(FRAGMENT_B_NAME, 0)
        }
    }
}