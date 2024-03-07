package com.example.aston_intensiv_4.utils

import android.os.Build
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.lifecycle.LifecycleOwner
import java.io.Serializable

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

fun <T : Serializable> Bundle.getSerializableCompat(key: String, clazz: Class<T>): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        this.getSerializable(key,clazz)
    } else {
        (this.getSerializable(key) as T)
    }
}