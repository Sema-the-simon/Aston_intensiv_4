package com.example.aston_intensiv_4

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit

fun FragmentManager.setFragment(@IdRes view: Int, instance: Fragment, name: String) {
    this.commit {
        replace(view, instance)
        setReorderingAllowed(true)
        addToBackStack(name)
    }
}