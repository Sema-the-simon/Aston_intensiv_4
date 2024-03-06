package com.example.aston_intensiv_4.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aston_intensiv_4.R
import com.example.aston_intensiv_4.databinding.FragmentCBinding

class FragmentC : BaseFragment<FragmentCBinding>(
    R.layout.fragment_c
) {
    override fun createBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentCBinding {
        return FragmentCBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}