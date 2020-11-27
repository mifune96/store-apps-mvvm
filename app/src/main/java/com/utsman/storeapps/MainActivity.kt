package com.utsman.storeapps

import android.os.Bundle
import android.viewbinding.library.activity.viewBinding
import androidx.appcompat.app.AppCompatActivity
import com.utsman.abstraction.base.SimplePagerAdapter
import com.utsman.home.ui.HomeFragment
import com.utsman.listing.ui.InstalledAppFragment
import com.utsman.storeapps.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val homeFragment = HomeFragment()
        val installedAppFragment = InstalledAppFragment()
        val pagerAdapter = SimplePagerAdapter(supportFragmentManager).apply {
            addFragment(installedAppFragment, homeFragment)
        }

        binding.run {
            mainViewPager.adapter = pagerAdapter
        }
    }
}