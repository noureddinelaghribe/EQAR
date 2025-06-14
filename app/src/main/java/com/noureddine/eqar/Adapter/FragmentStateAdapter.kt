package com.noureddine.eqar.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.noureddine.eqar.Fragment.AddRealStateFragment
import com.noureddine.eqar.Fragment.AdvancedSearchFragment
import com.noureddine.eqar.Fragment.FavoriteFragment
import com.noureddine.eqar.Fragment.HomeFragment
import com.noureddine.eqar.Fragment.ProfileFragment

// If you’re setting up your ViewPager2 in an Activity…
class ScreenSlidePagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    // Return the total number of pages
    override fun getItemCount(): Int = 5  // ← change to your number of fragments

    // Return a new fragment instance for a given page position
    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> HomeFragment()
            1 -> AdvancedSearchFragment()
            2 -> AddRealStateFragment()
            3 -> FavoriteFragment()
            4 -> ProfileFragment()
            else -> throw IndexOutOfBoundsException()
        }
}
