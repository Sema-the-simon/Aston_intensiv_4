package com.example.aston_intensiv_4.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aston_intensiv_4.R
import com.example.aston_intensiv_4.databinding.FragmentBBinding


class FragmentB : BaseFragment<FragmentBBinding>(
    R.layout.fragment_b
) {
    override fun createBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentBBinding {
        return FragmentBBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}