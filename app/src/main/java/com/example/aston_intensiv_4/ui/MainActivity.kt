package com.example.aston_intensiv_4.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.aston_intensiv_4.R
import com.example.aston_intensiv_4.databinding.ActivityMainBinding
import com.example.aston_intensiv_4.ui.part1.FRAGMENT_A_NAME
import com.example.aston_intensiv_4.ui.part1.FragmentA

const val SHOW_NAV_BUTTONS_KEY = "SHOW_NAV_BUTTONS_KEY"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnToPart1.setOnClickListener {
                supportFragmentManager.commit {
                    replace(R.id.mainFragmentContainer, FragmentA())
                    setReorderingAllowed(true)
                    addToBackStack(FRAGMENT_A_NAME)
                }
                mainButtons.visibility = View.GONE
            }

            btnToPart2.setOnClickListener {

            }
        }

        supportFragmentManager.setFragmentResultListener(
            SHOW_NAV_BUTTONS_KEY, this
        ) { _, _ ->
            binding.mainButtons.visibility = View.VISIBLE
        }
    }
}