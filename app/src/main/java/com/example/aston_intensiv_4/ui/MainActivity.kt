package com.example.aston_intensiv_4.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.aston_intensiv_4.R
import com.example.aston_intensiv_4.databinding.ActivityMainBinding
import com.example.aston_intensiv_4.setFragment
import com.example.aston_intensiv_4.ui.part1.FRAGMENT_A_NAME
import com.example.aston_intensiv_4.ui.part1.FragmentA
import com.example.aston_intensiv_4.ui.part2.USER_LIST_FRAGMENT_NAME
import com.example.aston_intensiv_4.ui.part2.UserListFragment

const val SHOW_NAV_BUTTONS_KEY = "SHOW_NAV_BUTTONS_KEY"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnToPart1.setOnClickListener {
                supportFragmentManager.setFragment(
                    R.id.mainFragmentContainer,
                    FragmentA(),
                    FRAGMENT_A_NAME
                )
                mainButtons.visibility = View.GONE
            }

            btnToPart2.setOnClickListener {
                supportFragmentManager.setFragment(
                    R.id.mainFragmentContainer,
                    UserListFragment(),
                    USER_LIST_FRAGMENT_NAME
                )
                mainButtons.visibility = View.GONE
            }
        }

        supportFragmentManager.setFragmentResultListener(
            SHOW_NAV_BUTTONS_KEY, this
        ) { _, _ ->
            binding.mainButtons.visibility = View.VISIBLE
        }
    }
}