package com.nyinyihtunlwin.cocktails.feature.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.nyinyihtunlwin.cocktails.feature.cocktails.list.CocktailsFragment
import com.nyinyihtunlwin.data.network.ApiConstants


class SectionPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                CocktailsFragment.newInstance(ApiConstants.TYPE_ALCOHOLIC)
            }
            1 -> {
                CocktailsFragment.newInstance(ApiConstants.TYPE_NON_ALCOHOLIC)
            }
            else -> {
                CocktailsFragment.newInstance(ApiConstants.TYPE_ALCOHOLIC)
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }
}