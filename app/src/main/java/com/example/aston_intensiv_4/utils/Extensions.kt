package com.example.aston_intensiv_4.utils

import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.lifecycle.LifecycleOwner

fun FragmentManager.setFragment(@IdRes view: Int, instance: Fragment, name: String) {
    this.commit {
        replace(view, instance)
        setReorderingAllowed(true)
        addToBackStack(name)
    }
}

fun Fragment.setOnBackPressedCallback(
    owner: LifecycleOwner? = null,
    onBackPressed: OnBackPressedCallback.() -> Unit
) {
    requireActivity().onBackPressedDispatcher.addCallback(owner) { onBackPressed() }
}